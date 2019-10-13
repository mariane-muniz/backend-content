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
@Table( name = "tabs" )
public class Tab extends AbstractAudit {
    
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

    @Column( nullable = false )
    private String title;

    
    @ManyToMany
    @JoinTable(
        name = "tab_elem_rel",
        joinColumns = @JoinColumn(name = "tab_id"),
        inverseJoinColumns = @JoinColumn(name = "element_id")
    )
    private Set<Element> elements;

    @ManyToMany(mappedBy = "tabs")
    private Set<TabGroup> tabGroups;

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
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Set<Element> return the elements
     */
    public Set<Element> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(Set<Element> elements) {
        this.elements = elements;
    }

    /**
     * @return Set<TabGroup> return the tabGroups
     */
    public Set<TabGroup> getTabGroups() {
        return tabGroups;
    }

    /**
     * @param tabGroups the tabGroups to set
     */
    public void setTabGroups(Set<TabGroup> tabGroups) {
        this.tabGroups = tabGroups;
    }
}