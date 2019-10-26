package com.channel.content.controllers;

import java.io.IOException;

import javax.annotation.Resource;

import com.channel.content.dtos.EntityData;
import com.channel.content.facades.TableFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(
    origins = "*",
    allowedHeaders = "*",
    allowCredentials = "false"
)
@RestController
@RequestMapping("/list")
public class TableController {

    private final static Logger LOG = LoggerFactory.getLogger(TableController.class);

    @Resource
    private TableFacade tableFacade;

    @GetMapping("/{entityName}")
    public ResponseEntity<EntityData> getList(@PathVariable("entityName") final String entityName,
            @RequestParam(name = "attributes", required = false) final String attributes) {
        try {
            final EntityData data = this.tableFacade.getList(entityName);
            return new ResponseEntity<EntityData>(data, HttpStatus.ACCEPTED);
        } catch (JsonParseException | IOException e) {
            LOG.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
