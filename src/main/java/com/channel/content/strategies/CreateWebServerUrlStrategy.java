package com.channel.content.strategies;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.channel.content.models.Element;
import com.channel.content.models.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component("createWebServerUrlStrategy")
public class CreateWebServerUrlStrategy {

    private final static Logger LOG = 
        LoggerFactory.getLogger(CreateWebServerUrlStrategy.class);

    public Map<String, String> generate(final Table table, final String mainUrl) {
        final Set<Element> columns = table.getColumns();
        Map<String, String> mappedUrls = new HashMap<>();
        if (!CollectionUtils.isEmpty(columns)) {
            for(Element e: columns) {
                final String serverAddress = e.getWebService().getServerAddress();
                if(!mainUrl.equals(serverAddress)) {
                    final String attrName = e.getAttributeName().toLowerCase();
                    final String objectName = table.getClassName().toLowerCase();
                    final String elementUrl = serverAddress + "/" + attrName 
                        + "/search/findBy" + StringUtils.capitalize(objectName) 
                        + "CodeIn?codes=";
                    this.setServers(elementUrl, attrName, mainUrl, mappedUrls);
                }
            }
            return mappedUrls;
        }
        else {
            LOG.error("Table with empty columns: " + table.getClassName());
        } 
        return null;
    }

    private void setServers(final String elementUrl, final String attrName,
        final String mainUrl, final Map<String, String> mappedUrls) {
        if (!mappedUrls.containsKey(attrName) && !mainUrl.equals(elementUrl)) {
            mappedUrls.put(attrName, elementUrl);
        }
    }
}