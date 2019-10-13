package com.channel.content.repositories;

import com.channel.content.models.Element;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "element", path = "elements")
public interface ElementRepository extends CrudRepository<Element, Long> {
}