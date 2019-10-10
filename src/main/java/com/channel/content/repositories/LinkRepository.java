package com.channel.content.repositories;

import com.channel.content.models.Link;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "link", path = "links")
public interface LinkRepository extends CrudRepository<Link, Long> {
}