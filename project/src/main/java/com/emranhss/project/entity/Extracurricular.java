package com.emranhss.project.entity;

import jakarta.persistence.*;

@Entity
public class Extracurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String role;
    private String description;

    @ManyToOne
    private JobSeeker jobSeeker;

    public Extracurricular() {
    }

    public Extracurricular(int id, String title, String role, String description, JobSeeker jobSeeker) {
        this.id = id;
        this.title = title;
        this.role = role;
        this.description = description;
        this.jobSeeker = jobSeeker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}
