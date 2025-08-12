package com.emranhss.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Extracurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
