package com.channel.content.repositories;

import com.channel.content.models.Tab;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tab", path = "tabs")
public interface TabRepository extends CrudRepository<Tab, Long> {
}