package com.channel.content.factories.impl;

import java.util.Set;

import com.channel.content.dtos.ColumnData;
import com.channel.content.factories.ColumnFactory;
import com.channel.content.models.Element;
import com.channel.content.models.OfficeUiColumn;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component("officeUiTableColumnFactory")
public class OfficeUiTableColumnFactory implements ColumnFactory {

    @Override
    public ColumnData create(final Element element, final int key) {

        // final OfficeUiColumn column = this.getColumn(element);
        final ColumnData data = new ColumnData();
        data.setKey("column" + key);
        data.setName(element.getPublicName());
        data.setFieldName(element.getAttributeName());
        data.setData(element.getType());
        return data;
    }

    private OfficeUiColumn getColumn(final Element element) {
        // TODO setar a column referente ao usuario que solicitou
        OfficeUiColumn column = null;
        final Set<OfficeUiColumn> columns = element.getColumns();
        if (CollectionUtils.isEmpty(columns)) {
            column = columns.iterator().next();
        }
        return column;
    }
}