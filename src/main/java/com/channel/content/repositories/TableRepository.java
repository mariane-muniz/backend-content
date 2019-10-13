package com.channel.content.repositories;

import com.channel.content.models.Table;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "table", path = "tables")
public interface TableRepository extends CrudRepository<Table, Long> {
}