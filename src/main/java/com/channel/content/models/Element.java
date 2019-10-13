package com.channel.content.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table( name = "elements" )
public class Element extends AbstractAudit {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
        name = "question_generator",
        sequenceName = "question_sequence",
        initialValue = 1000
    )
    private Long id;

    @Column( nullable = false, name = "class_name" )
    private String className;

    @Column( nullable = false, name = "attr_name" )
    private String attributeName;

    @Column( nullable = false )
    private String type;

    @ManyToMany(mappedBy = "elements")
    private Set<Tab> tabs;
}