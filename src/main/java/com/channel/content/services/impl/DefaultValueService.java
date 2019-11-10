package com.channel.content.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.channel.content.models.Element;
import com.channel.content.models.Table;
import com.channel.content.services.ValueService;
import com.channel.content.strategies.CreateWebServerUrlStrategy;
import com.channel.content.strategies.JsonEntityToMapStrategy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component("valueService")
public class DefaultValueService implements ValueService {

    @SuppressWarnings("unused")
    private final static Logger LOG = 
        LoggerFactory.getLogger(DefaultValueService.class);

    @Resource
    private CreateWebServerUrlStrategy createWebServerUrlStrategy;

    @Resource
    private JsonEntityToMapStrategy jsonEntityToMapStrategy;

    @Override
    public List<Map<String, Object>> getValues(final Table table)
            throws JsonParseException, JsonMappingException, IOException {

        final String mainWebServerUrl = this.getMainWebServiceCodes(table);
        final String mainElements = this.getWebServiceValues(mainWebServerUrl);
        final JSONArray mainValuesArray = this.convertJsonStringToArray(mainElements);

        final Map<String, JSONArray> elementList = new HashMap<>();
        final String mainElementCodes = this.extractElementCodes(mainValuesArray);
        final Map<String, String> mappedUrls = 
            this.createWebServerUrlStrategy
                .generate(table, table.getMainService().getServerAddress());
        
        for (Map.Entry<String, String>entry: mappedUrls.entrySet()) {
            String elementUrl = entry.getValue() + mainElementCodes;
            final String elements = this.getWebServiceValues(elementUrl);
            final JSONArray elementArray = this.convertJsonStringToArray(elements);
            elementList.put(entry.getKey(), elementArray);
        }
        final List<Map<String, Object>> result = 
            this.generateMap(table, mainValuesArray);
        this.populateMapExtraValues(result, elementList, table);
        return result;
    }

    private void populateMapExtraValues(final List<Map<String, Object>> result, 
        final Map<String, JSONArray> elementList, final Table table) {
        final String objectName = table.getClassName();
        result.parallelStream().forEach(el -> {
            final String elementCode = (String) el.get("code");
            for(Map.Entry<String, JSONArray> entry: elementList.entrySet()) {
                final String attrName = entry.getKey();
                final JSONArray attrArray = entry.getValue();
                attrArray.forEach(attr -> {
                    final String attrCode = ((JSONObject) attr).getString(objectName + "Code");
                    if(attrCode.equals(elementCode)) {
                        Object value = ((JSONObject) attr).get(attrName);
                        el.put(attrName, value);
                    }
                });
            }
        });
    }

    private List<Map<String, Object>> generateMap(final Table table, 
        final JSONArray mainValuesArray) {
        final List<Map<String, Object>> list = new ArrayList<>();
        final Set<Element> columns = table.getColumns();
        mainValuesArray.forEach(value -> {
            final Map<String, Object> obj = new HashMap<>();
            columns.forEach(column -> {
                final String attrName = column.getAttributeName();
                final Object object = 
                    this.getValueFromJson((JSONObject)value, attrName);
                obj.put(attrName, object);
            });
            list.add(obj);
        });
        return list;
    }

    private Object getValueFromJson(final JSONObject value, final String attrName) {
        try {
            return ((JSONObject)value).get(attrName);
        }
        catch (JSONException e) {
            // IGNORE its possible that json object do not have the property.
        }
        return null;
    }

    private JSONArray convertJsonStringToArray(final String jsonString) {
        final JSONObject m = new JSONObject(jsonString);
        final JSONObject embeddedJson = (JSONObject) m.get("_embedded");
        final String firstKey = embeddedJson.keys().next().toString();
        final JSONArray mainValuesArray = (JSONArray) embeddedJson.get(firstKey);
        return mainValuesArray;
    }

    private String extractElementCodes(final JSONArray jsonArray) {
        final List<String> elementCodes = new ArrayList<>();
        jsonArray.forEach(el -> {
            final JSONObject obj = (JSONObject)el;
            final String code = obj.getString("code");
            elementCodes.add(code);
        });
        return elementCodes.stream().map(Object::toString)
            .collect(Collectors.joining(","));
    }

    private String getMainWebServiceCodes(final Table table) {
        final String mainService = table.getMainService().getServerAddress();
        final String object = table.getClassName().toLowerCase();
        return mainService + "/" + object;
    }

    private String getWebServiceValues(final String URL) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL);
        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                String.class);
        return response.getBody();
    }
}