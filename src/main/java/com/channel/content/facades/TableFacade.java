package com.channel.content.facades;

import java.io.IOException;

import com.channel.content.dtos.EntityData;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.boot.json.JsonParseException;

public interface TableFacade {
    EntityData getList(final String entityName) throws JsonParseException, JsonMappingException, IOException;
}