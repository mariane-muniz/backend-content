package com.channel.content.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "web_services" )
public class WebService extends AbstractAudit {

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
    private String name;

    @Column( nullable = false, name = "server_address" )
    private String serverAddress;

    @Column( nullable = false )
    private String code;

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "webService"
    )
    private Set<Element> elements;

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "mainService"
    )
    private Set<com.channel.content.models.Table> tables;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServerAddress() {
        return this.serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Element> getElements() {
        return this.elements;
    }

    public void setElements(Set<Element> elements) {
        this.elements = elements;
    }

    public Set<com.channel.content.models.Table> getTables() {
        return this.tables;
    }

    public void setTables(Set<com.channel.content.models.Table> tables) {
        this.tables = tables;
    }

    public WebService id(Long id) {
        this.id = id;
        return this;
    }

    public WebService name(String name) {
        this.name = name;
        return this;
    }

    public WebService serverAddress(String serverAddress) {
        this.serverAddress = serverAddress;
        return this;
    }

    public WebService code(String code) {
        this.code = code;
        return this;
    }

    public WebService elements(Set<Element> elements) {
        this.elements = elements;
        return this;
    }

    public WebService tables(Set<com.channel.content.models.Table> tables) {
        this.tables = tables;
        return this;
    }
}