package com.channel.content.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.channel.content.models.Element;
import com.channel.content.models.Table;
import com.channel.content.services.TableService;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component("tableService")
public class DefaultTableService implements TableService {

    @Override
    public Map<String, String> getLabels(final Table entity) {

        final Map<String, String> map = new HashMap<>();
        final Set<Element> columns = entity.getColumns();

        if (!CollectionUtils.isEmpty(columns)) {
            for (final Element column : columns) {
                map.put(column.getAttributeName(), column.getPublicName());
            }
        }
        return map;
    }
}