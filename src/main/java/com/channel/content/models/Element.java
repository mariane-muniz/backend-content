package com.channel.content.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "elements")
public class Element extends AbstractAudit {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", initialValue = 1000)
    private Long id;

    @Column(nullable = false, name = "class_name")
    private String className;

    @Column(nullable = false, name = "attr_name")
    private String attributeName;

    @Column(nullable = false)
    private String type;

    @Column( nullable = false )
    private String publicName;

    @ManyToMany(mappedBy = "elements")
    private Set<Tab> tabs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable = true)
    private com.channel.content.models.Table table;


    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "element"
    )
    private Set<OfficeUiColumn> columns;
    

    public Set<OfficeUiColumn> getColumns() {
        return this.columns;
    }

    public void setColumns(final Set<OfficeUiColumn> columns) {
        this.columns = columns;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
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

    /**
     * @return com.channel.content.models.Table return the table
     */
    public com.channel.content.models.Table getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(com.channel.content.models.Table table) {
        this.table = table;
    }
}