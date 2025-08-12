package com.emranhss.project.entity;

import jakarta.persistence.*;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String institute;
    private String duration;
    private String description;

    @ManyToOne
    private JobSeeker jobSeeker;

    public Training() {
    }

    public Training(int id, String title, String institute, String duration, String description, JobSeeker jobSeeker) {
        this.id = id;
        this.title = title;
        this.institute = institute;
        this.duration = duration;
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

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
