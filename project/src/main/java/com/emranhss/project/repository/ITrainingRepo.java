package com.emranhss.project.repository;

import com.emranhss.project.entity.Hobby;
import com.emranhss.project.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainingRepo extends JpaRepository<Training,Integer> {
    List<Training> findByJobSeekerId(Long jobseekerId);
}
