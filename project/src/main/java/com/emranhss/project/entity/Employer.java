package com.emranhss.project.entity;

import jakarta.persistence.*;

@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private String companyAddress;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Employer() {
    }

    public Employer(int id, String companyName, String companyAddress, User user) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
