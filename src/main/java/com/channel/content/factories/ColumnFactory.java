package com.channel.content.factories;

import com.channel.content.dtos.ColumnData;
import com.channel.content.models.Element;

public interface ColumnFactory {
    ColumnData create(Element element, final int key);
}