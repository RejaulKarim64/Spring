package com.emranhss.project.service;

import com.emranhss.project.dto.HobbyDTO;
import com.emranhss.project.dto.SkillDTO;
import com.emranhss.project.entity.Hobby;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.Skill;
import com.emranhss.project.repository.ISkillRepo;
import com.emranhss.project.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Autowired
    private ISkillRepo skillRepo;
    @Autowired
    private JobSeekerRepository jobSeekerRepo;

    public List<SkillDTO> getByJobseekerId(Long jobseekerId) {
        List<Skill> skills= skillRepo.findByJobSeekerId(jobseekerId);
        return skills.stream()
                .map(SkillDTO::new)
                .collect(Collectors.toList());
    }
    public Skill save(Skill skill, String email) {
        JobSeeker jobSeeker=jobSeekerRepo.findByUserEmail(email);
        skill.setJobSeeker(jobSeeker);
        return skillRepo.save(skill);
    }
    public void delete(int id) {
        skillRepo.deleteById(id);
    }
}
