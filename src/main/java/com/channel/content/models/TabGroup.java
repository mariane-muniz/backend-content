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

@Entity
@Table( name = "tab_groups" )
public class TabGroup extends AbstractAudit {

    private static final long serialVersionUID = 1L;

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

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return Set<Tab> return the tabs
     */
    public Set<Tab> getTabs() {
        return tabs;
    }

    /**
     * @param tabs the tabs to set
     */
    public void setTabs(Set<Tab> tabs) {
        this.tabs = tabs;
    }

}