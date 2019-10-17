package com.channel.content.services;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.boot.json.JsonParseException;

public interface JsonService {
    public HashMap<String,Object> toMap(final String json) throws JsonParseException, JsonMappingException, IOException;
}