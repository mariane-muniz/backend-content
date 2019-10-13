package com.channel.content.repositories;

import com.channel.content.models.TabGroup;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tab_group", path = "tab_groups")
public interface TabGroupRepository extends CrudRepository<TabGroup, Long> {
    
}