package com.emranhss.project.dto;

import com.emranhss.project.entity.Language;

public class LanguageDTO {
    private int id;
    private String name;
    private String proficiency;

    // Constructor to map from entity
    public LanguageDTO(Language language) {
        this.id = language.getId();
        this.name = language.getName();
        this.proficiency = language.getProficiency();
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
}
