package com.channel.content.dtos;

import lombok.Data;

@Data
public class ColumnData {
    
    private String key;
    private String name;
    private String fieldName;
    private int minWidth = 0;
    private boolean isRowHeader = true;
    private boolean isResizable = true;
    private boolean isSorted = true;
    private boolean isSortedDescending = false;
    private String sortAscendingAriaLabel = "Sorted A to Z";
    private String sortDescendingAriaLabel = "Sorted Z to A";
    private String onColumnClick = "this._onColumnClick";
    private String data;
    private boolean isPadded = true;
}