package com.channel.content.services;

import java.util.List;

import com.channel.content.dtos.ColumnData;
import com.channel.content.models.Table;

public interface TableService {
    Table findOneByClassName(final String entityName);
    List<ColumnData> getTableHeader(final Table table);
}