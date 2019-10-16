package com.channel.content.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
    origins = "*",
    allowedHeaders = "*" 
)
@RestController
@RequestMapping("/teste")
public class TestController {

    @ResponseBody
    @GetMapping
    public String testMethod() {
        return "{It´s okay}";
    }
}