package com.emranhss.project.service;

import com.emranhss.project.dto.HobbyDTO;
import com.emranhss.project.entity.Hobby;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.repository.IHobbyRepo;
import com.emranhss.project.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HobbyService {

    @Autowired
    private IHobbyRepo hobbyRepo;
    @Autowired
    private JobSeekerRepository jobSeekerRepo;

    public List<HobbyDTO> getByJobseekerId(Long jobseekerId) {
        List<Hobby> hobbies= hobbyRepo.findByJobSeekerId(jobseekerId);
        return hobbies.stream()
                .map(HobbyDTO::new)
                .collect(Collectors.toList());
    }
    public Hobby save(Hobby hobby, String email) {
        JobSeeker jobSeeker= jobSeekerRepo.findByUserEmail(email);

        hobby.setJobSeeker(jobSeeker);
        return hobbyRepo.save(hobby);

    }
    public void delete(int id) {
        hobbyRepo.deleteById(id);
    }
}
