package com.channel.content.controllers;

import javax.annotation.Resource;

import com.channel.content.facades.TableFacade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class TableController {

    @Resource
    private TableFacade tableFacade;

    @GetMapping("/{entityName}")
    public ResponseEntity getList(
        @PathVariable("entityName") final String entityName,
        @RequestParam(name = "attributes", required = false) final String attributes) {

        this.tableFacade.getList(entityName);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
