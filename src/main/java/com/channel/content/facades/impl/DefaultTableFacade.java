package com.channel.content.facades.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.channel.content.controllers.services.CatalogWebService;
import com.channel.content.facades.TableFacade;
import com.channel.content.models.Element;
import com.channel.content.models.Table;
import com.channel.content.repositories.TableRepository;

import org.springframework.stereotype.Component;

@Component("tableFacade")
public class DefaultTableFacade implements TableFacade {

    @Resource
    private TableRepository tableRepository;

    @Resource
    private CatalogWebService catalogWebService;

    public void getList(final String entityName) {

        final Table entity = this.tableRepository.findOneByClassName(entityName);
        if (Objects.nonNull(entity)) {
            final String elements = this.catalogWebService.getCatalogElements(entityName);
        }



        // final List<String> attributes = entity.getColumns().stream().map(Element::getAttributeName)
        //             .collect(Collectors.toList());
    }
}