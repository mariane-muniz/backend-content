package com.channel.content.strategies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.channel.content.models.Element;
import com.channel.content.models.Table;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.util.StringUtils;

@Component("jsonEntityToMapStrategy")
public class JsonEntityToMapStrategy {

    @SuppressWarnings("unused")
    private final static Logger LOG = LoggerFactory.getLogger(JsonEntityToMapStrategy.class);

    public List<Map<String, Object>> convert(final String jsonEntities, final Table table) {
        if (StringUtils.isNotEmpty(jsonEntities)) {
            final List<String> attributes = table.getColumns().stream().map(Element::getAttributeName)
                    .collect(Collectors.toList());
            Pattern p = Pattern.compile("\\{(.*?)\\}");
            Matcher m = p.matcher(jsonEntities);
            return this.listToMap(m, attributes);
        }
        return null;
    }

    private List<Map<String, Object>> listToMap(final Matcher m, final List<String> attributes) {
        final List<Map<String, Object>> list = new ArrayList<>();
        while (m.find()) {
            final String jsonProduct = "{" + m.group(1) + "}";
            try {
                Map<String, Object> entityMap = new HashMap<>();
                final HashMap<String, Object> map = this.toMap(jsonProduct);
                for (final String attr : attributes) {
                    entityMap.put(attr, map.get(attr));
                }
                list.add(entityMap);
            } catch (JsonParseException | IOException e) {
                LOG.error(e.getMessage());
            }
        }
        return list;
    }

    private  HashMap<String,Object> toMap(final String json) 
        throws JsonParseException, JsonMappingException, IOException {
        return new ObjectMapper().readValue(json, HashMap.class);
    }
}