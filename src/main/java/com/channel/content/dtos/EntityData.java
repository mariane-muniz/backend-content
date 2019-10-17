package com.channel.content.dtos;

import java.util.List;
import java.util.Map;

public class EntityData {
    private List<Map<String, Object>> result;
    private List<Map<String, String>> detail;
    private List<Map<String, String>> labels;
    private int count;

    public List<Map<String, Object>> getResult() {
        return result;
    }

    public List<Map<String, String>> getLabels() {
        return labels;
    }

    public void setLabels(List<Map<String, String>> labels) {
        this.labels = labels;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Map<String, String>> getDetail() {
        return detail;
    }

    public void setDetail(List<Map<String, String>> detail) {
        this.detail = detail;
    }

    public void setResult(List<Map<String, Object>> result) {
        this.result = result;
    }
}