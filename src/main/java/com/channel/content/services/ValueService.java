package com.channel.content.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.channel.content.models.Table;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ValueService {
    List<Map<String, Object>> getValues(final Table table) 
        throws JsonParseException, JsonMappingException, IOException;
}