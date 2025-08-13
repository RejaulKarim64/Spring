package com.emranhss.project.service;

import com.emranhss.project.dto.TrainingDTO;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.Training;
import com.emranhss.project.repository.ITrainingRepo;
import com.emranhss.project.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    @Autowired
    private ITrainingRepo trainingRepo;
    @Autowired
    private JobSeekerRepository jobSeekerRepo;


    public List<TrainingDTO> getByJobseekerId(Long jobseekerId) {
        List<Training> trainings = trainingRepo.findByJobSeekerId(jobseekerId);

        return trainings.stream()
                .map(TrainingDTO::new)
                .collect(Collectors.toList());

    }

    public Training save(Training training, String email) {
        JobSeeker jobSeeker = jobSeekerRepo.findByUserEmail(email);
        training.setJobSeeker(jobSeeker);
        return trainingRepo.save(training);
    }

    public void delete(int id) {
        trainingRepo.deleteById(id);
    }
}
