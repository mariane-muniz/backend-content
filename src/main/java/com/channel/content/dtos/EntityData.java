package com.channel.content.dtos;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class EntityData {

    private List<ColumnData> columns;
    private List<Map<String, Object>> values;
}