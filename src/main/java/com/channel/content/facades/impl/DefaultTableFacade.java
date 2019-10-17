package com.channel.content.facades.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.channel.content.dtos.EntityData;
import com.channel.content.facades.TableFacade;
import com.channel.content.models.Element;
import com.channel.content.models.Table;
import com.channel.content.repositories.TableRepository;
import com.channel.content.services.CatalogWebService;
import com.channel.content.services.JsonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.util.StringUtils;

@Component("tableFacade")
public class DefaultTableFacade implements TableFacade {

    private final static Logger LOG = LoggerFactory.getLogger(DefaultTableFacade.class);

    @Resource
    private TableRepository tableRepository;

    @Resource
    private CatalogWebService catalogWebService;

    @Resource
    private JsonService jsonService;

    @Override
    public EntityData getList(final String entityName) {
        final List<Map<String, Object>> list = new ArrayList<>();
        final Table entity = this.tableRepository.findOneByClassName(entityName);
        if (Objects.nonNull(entity)) {
            final EntityData data = new EntityData();
            final String elements = this.catalogWebService.getCatalogElements(entityName);
            if (StringUtils.isNotEmpty(elements)) {
                final List<String> attributes = entity.getColumns().stream().map(Element::getAttributeName)
                    .collect(Collectors.toList());
                Pattern p = Pattern.compile("\\{(.*?)\\}");
                Matcher m = p.matcher(elements);
                while (m.find()) {
                    final String jsonProduct = "{" + m.group(1) + "}";
                    try {
                        final HashMap<String, Object> map = this.jsonService.toMap(jsonProduct);
                        Map<String, Object> entityMap = new HashMap<>();
                        for (final String attr : attributes) {
                            entityMap.put(attr, map.get(attr));
                        }
                        list.add(entityMap);
                    } 
                    catch (JsonParseException | IOException e) {
                        LOG.error(e.getMessage());
                    }
                }
                final List<Map<String, String>> elementList = new ArrayList<>();
                for (final Element element : entity.getColumns()) {
                    Map<String, String> elMap = new HashMap<>();
                    elMap.put(element.getAttributeName(), element.getType());
                    elementList.add(elMap);
                }
                data.setDetail(elementList);
            }
            data.setResult(list);
            return data;
        }
        return null;
    }
}