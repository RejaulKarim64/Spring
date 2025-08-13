package com.emranhss.project.service;

import com.emranhss.project.dto.ExtracurricularDTO;
import com.emranhss.project.entity.Extracurricular;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.repository.IExtracurricularRepo;
import com.emranhss.project.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtracurricularService {

    @Autowired
    private IExtracurricularRepo extracurricularRepo;
    @Autowired
    private JobSeekerRepository jobSeekerRepo;

    public List<ExtracurricularDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Extracurricular> extracurriculars = extracurricularRepo.findByJobSeekerId(jobSeekerId);
        return extracurriculars.stream()
                .map(ExtracurricularDTO::new)
                .collect(Collectors.toList());
    }

    public Extracurricular save(Extracurricular extracurricular, String email) {
        JobSeeker jobSeeker = jobSeekerRepo.findByUserEmail(email);

        extracurricular.setJobSeeker(jobSeeker);
        return extracurricularRepo.save(extracurricular);
    }
    public void delete(int id) {
        extracurricularRepo.deleteById(id);
    }
}
