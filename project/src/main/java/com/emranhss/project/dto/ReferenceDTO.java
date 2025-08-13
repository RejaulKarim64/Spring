package com.emranhss.project.dto;

import com.emranhss.project.entity.Reference;

public class ReferenceDTO {

    private int id;
    private String name;
    private String contact;
    private String relation;

    // Constructor to map from entity
    public ReferenceDTO(Reference reference) {
        this.id = reference.getId();
        this.name = reference.getName();
        this.contact = reference.getContact();
        this.relation = reference.getRelation();
    }
}
