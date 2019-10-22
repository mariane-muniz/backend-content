package com.channel.content.services;

import java.util.Map;

import com.channel.content.models.Table;

public interface TableService {
    Map<String, String> getLabels(final Table entity);
}