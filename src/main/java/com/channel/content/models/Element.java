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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "web_service_id", nullable = true)
    private WebService webService;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublicName() {
        return this.publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public Set<Tab> getTabs() {
        return this.tabs;
    }

    public void setTabs(Set<Tab> tabs) {
        this.tabs = tabs;
    }

    public com.channel.content.models.Table getTable() {
        return this.table;
    }

    public void setTable(com.channel.content.models.Table table) {
        this.table = table;
    }

    public Set<OfficeUiColumn> getColumns() {
        return this.columns;
    }

    public void setColumns(Set<OfficeUiColumn> columns) {
        this.columns = columns;
    }

    public WebService getWebService() {
        return this.webService;
    }

    public void setWebService(WebService webService) {
        this.webService = webService;
    }

    public Element id(Long id) {
        this.id = id;
        return this;
    }

    public Element className(String className) {
        this.className = className;
        return this;
    }

    public Element attributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public Element type(String type) {
        this.type = type;
        return this;
    }

    public Element publicName(String publicName) {
        this.publicName = publicName;
        return this;
    }

    public Element tabs(Set<Tab> tabs) {
        this.tabs = tabs;
        return this;
    }

    public Element table(com.channel.content.models.Table table) {
        this.table = table;
        return this;
    }

    public Element columns(Set<OfficeUiColumn> columns) {
        this.columns = columns;
        return this;
    }

    public Element webService(WebService webService) {
        this.webService = webService;
        return this;
    }
}