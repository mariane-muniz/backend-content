package com.channel.content.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
@Table( name = "tab_groups" )
public class TabGroup extends AbstractAudit {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column( nullable = false, unique = true )
    private String code;

    @ManyToMany
    @JoinTable(
        name = "tab_group_rel",
        joinColumns = @JoinColumn(name = "tab_group_id"),
        inverseJoinColumns = @JoinColumn(name = "tab_id")
    )
    private Set<Tab> tabs;
}