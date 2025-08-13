package com.emranhss.project.service;

import com.emranhss.project.dto.ReferenceDTO;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.Reference;
import com.emranhss.project.repository.IReferenceRepo;
import com.emranhss.project.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReferenceService {

    @Autowired
    private IReferenceRepo referenceRepo;
    @Autowired
    private JobSeekerRepository jobSeekerRepo;

    public List<ReferenceDTO> getByJobseekerId(Long jobseekerId) {
        List<Reference> references = referenceRepo.findByJobSeekerId(jobseekerId);
        return references.stream()
                .map(ReferenceDTO::new)
                .collect(Collectors.toList());
    }

    public Reference save(Reference reference, String email) {
        JobSeeker jobSeeker = jobSeekerRepo.findByUserEmail(email);
        reference.setJobSeeker(jobSeeker);
        return referenceRepo.save(reference);
    }
    public void delete(int id) {
        referenceRepo.deleteById(id);
    }
}
