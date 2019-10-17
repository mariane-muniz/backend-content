package com.channel.content.services.impl;

import java.io.IOException;
import java.util.HashMap;

import com.channel.content.facades.impl.DefaultTableFacade;
import com.channel.content.services.JsonService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

@Component("jsonService")
public class DefaultJsonService implements JsonService {

    @SuppressWarnings("unused")
    private final static Logger LOG = LoggerFactory.getLogger(DefaultTableFacade.class);

    @Override
    public HashMap<String,Object> toMap(final String json) throws JsonParseException, JsonMappingException, IOException {
        return new ObjectMapper().readValue(json, HashMap.class);
    }
}