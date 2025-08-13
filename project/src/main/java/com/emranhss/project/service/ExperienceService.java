package com.emranhss.project.service;

import com.emranhss.project.dto.ExperienceDTO;
import com.emranhss.project.entity.Experience;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.repository.IExperienceRepo;
import com.emranhss.project.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceService {

    @Autowired
    private IExperienceRepo experienceRepo;
    @Autowired
    private JobSeekerRepository jobSeekerRepo;

    public List<ExperienceDTO> getByJobSeekerId(Long jobSeekerId) {

        List<Experience> experiences = experienceRepo.findByJobSeekerId(jobSeekerId);

        return experiences.stream()
                .map(ExperienceDTO::new)
                .collect(Collectors.toList());
    }

    public Experience save(Experience experience, String email) {
        JobSeeker jobSeeker = jobSeekerRepo.findByUserEmail(email);


        experience.setJobSeeker(jobSeeker);
        return experienceRepo.save(experience);

    }

    public void delete(Long id) {
        experienceRepo.deleteById(id);
    }
}
