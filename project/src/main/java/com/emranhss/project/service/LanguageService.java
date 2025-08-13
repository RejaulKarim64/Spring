package com.emranhss.project.service;

import com.emranhss.project.dto.LanguageDTO;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.Language;
import com.emranhss.project.repository.ILanguageRepo;
import com.emranhss.project.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    @Autowired
    private ILanguageRepo languageRepo;
    @Autowired
    private JobSeekerRepository jobSeekerRepo;

    public List<LanguageDTO> getByJobSeekerId(Long jobseekerId) {
        List<Language> languages = languageRepo.findByJobSeekerId(jobseekerId);

        return languages.stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
    }

    public Language save(Language language, String email) {
        JobSeeker jobSeeker = jobSeekerRepo.findByUserEmail(email);

        language.setJobSeeker(jobSeeker);
        return languageRepo.save(language);
    }
    public void delete(int id) {
        languageRepo.deleteById(id);
    }
}
