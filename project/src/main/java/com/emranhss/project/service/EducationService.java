package com.emranhss.project.service;

import com.emranhss.project.dto.EducationDTO;
import com.emranhss.project.entity.Education;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.repository.IEducationRepo;
import com.emranhss.project.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    @Autowired
    private IEducationRepo educationRepo;
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<EducationDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Education> educations = educationRepo.findByJobSeekerId(jobSeekerId);
        return educations.stream()
                .map(EducationDTO::new)
                .collect(Collectors.toList());
    }

    public Education saveEducation(Education education, String email) {

        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email);
        education.setJobSeeker(jobSeeker);
        return educationRepo.save(education);
    }

    public void deleteEducation(Long id) {
        educationRepo.deleteById(id);
    }


}
