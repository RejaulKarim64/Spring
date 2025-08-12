package com.emranhss.project.entity;

import jakarta.persistence.*;

@Entity
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    private JobSeeker jobSeeker;

    public Hobby() {
    }

    public Hobby(int id, String name, JobSeeker jobSeeker) {
        this.id = id;
        this.name = name;
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

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}
