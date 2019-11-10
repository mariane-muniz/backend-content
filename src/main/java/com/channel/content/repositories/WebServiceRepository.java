package com.channel.content.repositories;

import com.channel.content.models.WebService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(
    origins = "*",
    allowedHeaders = "*",
    allowCredentials = "false"
)
@RepositoryRestResource(collectionResourceRel = "web-service", path = "web-services")
public interface WebServiceRepository extends CrudRepository<WebService, Long> {

}