package com.example.pirp2.entity;

import javax.persistence.*;


@Entity
@Table
public class Piro {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;


    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public Piro(String description, String tag, String naumen, String jiraID, String oldjiraID, byte data[], String docname, String doctype) {
        this.description = description;
        this.tag = tag;
        this.naumen = naumen;
        this.jiraID = jiraID;
        this.oldjiraID = oldjiraID;
        this.data=data;
        this.docname=docname;
        this.doctype=doctype;

    }


    String docname;
    String doctype;

    String description;


    String tag;

    String naumen;

    String jiraID;

    String oldjiraID;

    @Lob
    byte data[];

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getNaumen() {
        return naumen;
    }

    public void setNaumen(String naumen) {
        this.naumen = naumen;
    }

    public Piro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getJiraID() {
        return jiraID;
    }

    public void setJiraID(String jiraID) {
        this.jiraID = jiraID;
    }

    public String getOldjiraID() {
        return oldjiraID;
    }

    public void setOldjiraID(String oldjiraID) {
        this.oldjiraID = oldjiraID;
    }

    @Override
    public String toString() {
        return "Object name is: "+ description;
    }
}

