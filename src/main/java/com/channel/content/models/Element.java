package com.channel.content.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "elements" )
public class Element extends AbstractAudit {

    private static final long serialVersionUID = 1L;

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
     * @return String return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return String return the attributeName
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * @param attributeName the attributeName to set
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * @return String return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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