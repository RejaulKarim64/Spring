package com.emranhss.project.entity;

import jakarta.persistence.*;

@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contact;
    private String relation;

    @ManyToOne
    private JobSeeker jobSeeker;

    public Reference() {
    }

    public Reference(int id, String name, String contact, String relation, JobSeeker jobSeeker) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.relation = relation;
        this.jobSeeker = jobSeeker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}
