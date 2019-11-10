package com.channel.content.controllers;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.channel.content.models.WebService;
import com.channel.content.repositories.WebServiceRepository;

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

    @Resource
    private WebServiceRepository repository;

    @ResponseBody
    @GetMapping
    public String testMethod() {

        // WebService w1 = new WebService();
        // w1.setCode("dev-catalog");
        // w1.setName("Dev Catalog Server");
        // w1.setServerAddress("https://app-backend-catalog.herokuapp.com/");


        // WebService w2 = new WebService();
        // w2.setCode("dev-pricing");
        // w2.setName("Dev Pricing Server");
        // w2.setServerAddress("https://app-backend-pricing.herokuapp.com/");

        // ArrayList<WebService> list = new ArrayList<>();
        // list.add(w1);
        // list.add(w2);

        // this.repository.saveAll(list);


        return "{It´s okay}";
    }
}