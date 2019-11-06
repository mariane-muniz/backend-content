package com.channel.content.services.impl;

import com.channel.content.services.CatalogWebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component("catalogWebService")
public class DefaultCatalogWebService implements CatalogWebService {

    Logger logger = LoggerFactory.getLogger(DefaultCatalogWebService.class);

    private final static String CATALOG_WEB_SERVICE_URL = "https://app-backend-catalog.herokuapp.com";

    @Override
    public String getCatalogElements(final String entityName) {
        final RestTemplate restTemplate = new RestTemplate();
        // String lineAttributes = String.join("--", attributes);
        final String URL = CATALOG_WEB_SERVICE_URL + "/entity/find/" + entityName + "?attributes=name-description";
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL);
            // .queryParam("attributes", lineAttributes);
        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                String.class);

        return response.getBody();
    }
}