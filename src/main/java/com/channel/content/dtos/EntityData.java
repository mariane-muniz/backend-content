package com.channel.content.dtos;

import java.util.List;
import java.util.Map;

public class EntityData {
    private List<Map<String, Object>> result;
    private List<Map<String, String>> detail;
    private Map<String, String> labels;
    private int count;

    public List<Map<String, Object>> getResult() {
        return result;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
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