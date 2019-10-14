package com.channel.content.repositories;

import com.channel.content.models.Table;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(
    origins = "*",
    allowedHeaders = "*",
    allowCredentials = "false"
)
@RepositoryRestResource(collectionResourceRel = "table", path = "tables")
public interface TableRepository extends CrudRepository<Table, Long> {
    public Table findOneByClassName(@Param("className") String className);
}