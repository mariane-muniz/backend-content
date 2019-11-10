package com.channel.content.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@javax.persistence.Table( name = "ie_table" )
public class Table extends AbstractAudit {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column( nullable = false ) 
    private String className;

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "table"
    )
    private Set<Element> columns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_service_id", nullable = true)
    private WebService mainService;

    @Column
    private String path;

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

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

    public Set<Element> getColumns() {
        return this.columns;
    }

    public void setColumns(Set<Element> columns) {
        this.columns = columns;
    }

    public WebService getMainService() {
        return this.mainService;
    }

    public void setMainService(WebService mainService) {
        this.mainService = mainService;
    }

    public Table id(Long id) {
        this.id = id;
        return this;
    }

    public Table className(String className) {
        this.className = className;
        return this;
    }

    public Table columns(Set<Element> columns) {
        this.columns = columns;
        return this;
    }

    public Table mainService(WebService mainService) {
        this.mainService = mainService;
        return this;
    }
}