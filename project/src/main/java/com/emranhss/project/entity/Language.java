package com.emranhss.project.entity;

import jakarta.persistence.*;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String proficiency; // Basic, Fluent, Native

    @ManyToOne
    private JobSeeker jobSeeker;

    public Language() {
    }

    public Language(int id, String name, String proficiency, JobSeeker jobSeeker) {
        this.id = id;
        this.name = name;
        this.proficiency = proficiency;
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

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}
