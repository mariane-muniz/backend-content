package com.channel.content.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.channel.content.dtos.ColumnData;
import com.channel.content.factories.impl.OfficeUiTableColumnFactory;
import com.channel.content.models.Element;
import com.channel.content.models.Table;
import com.channel.content.repositories.TableRepository;
import com.channel.content.services.TableService;
import com.channel.content.strategies.JsonEntityToMapStrategy;

import org.springframework.stereotype.Component;

@Component("tableService")
public class DefaultTableService implements TableService {

    @Resource
    private OfficeUiTableColumnFactory officeUiTableColumnFactory;

    @Resource
    private JsonEntityToMapStrategy jsonEntityToMapStrategy;

    @Resource
    private TableRepository tableRepository;

    @Override
    public Table findOneByClassName(final String entityName) {
        return this.tableRepository.findOneByClassName(entityName);
    }

    @Override
    public List<ColumnData> getTableHeader(final Table table) {
        List<ColumnData> list = new ArrayList<>();
        final Set<Element> columns = table.getColumns();
        int counter = 1;
        for (final Element column : columns) {
            final ColumnData columnData = 
                this.officeUiTableColumnFactory.create(column, counter);
            list.add(columnData);
            counter++;
        }
        return list;
    }
}