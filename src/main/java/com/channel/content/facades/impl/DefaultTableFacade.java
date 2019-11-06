package com.channel.content.facades.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.channel.content.dtos.ColumnData;
import com.channel.content.dtos.EntityData;
import com.channel.content.facades.TableFacade;
import com.channel.content.models.Table;
import com.channel.content.services.CatalogWebService;
import com.channel.content.services.TableService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("tableFacade")
public class DefaultTableFacade implements TableFacade {

    @SuppressWarnings("unused")
    private final static Logger LOG = LoggerFactory.getLogger(DefaultTableFacade.class);

    @Resource
    private CatalogWebService catalogWebService;

    @Resource
    private TableService tableService;

    @Override
    public EntityData getList(final String entityName) {

        final EntityData data = new EntityData();
        final Table table = this.tableService.findOneByClassName(entityName);
        final List<ColumnData> columns = this.tableService.getTableHeader(table);
        List<Map<String, Object>> values = this.tableService.getTableValues(table);

        data.setColumns(columns);
        data.setValues(values);

        return data;
    }
}