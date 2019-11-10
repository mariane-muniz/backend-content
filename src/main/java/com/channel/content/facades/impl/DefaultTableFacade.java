package com.channel.content.facades.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.channel.content.dtos.ColumnData;
import com.channel.content.dtos.EntityData;
import com.channel.content.facades.TableFacade;
import com.channel.content.models.Table;
import com.channel.content.services.TableService;
import com.channel.content.services.ValueService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("tableFacade")
public class DefaultTableFacade implements TableFacade {

    @SuppressWarnings("unused")
    private final static Logger LOG = LoggerFactory.getLogger(DefaultTableFacade.class);

    @Resource
    private TableService tableService;

    @Resource
    private ValueService valueService;

    @Override
    public EntityData getList(final String entityName) {

        final EntityData data = new EntityData();
        final Table table = this.tableService.findOneByClassName(entityName);
        final List<ColumnData> columns = this.tableService.getTableHeader(table);
        try {
            List<Map<String, Object>> values = this.valueService.getValues(table);
            data.setValues(values);
            data.setColumns(columns);
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return data;
    }
}