package com.example.pirp2.entity;

import javax.persistence.*;

@Entity
@Table
public class Billionaires {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
   Integer id;

    public Billionaires(String first_name, String last_name, String career) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.career = career;
    }

    String first_name;


    String last_name;


    String career;

    public Billionaires() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
