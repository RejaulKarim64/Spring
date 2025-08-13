package com.emranhss.project.repository;

import com.emranhss.project.entity.Hobby;
import com.emranhss.project.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHobbyRepo extends JpaRepository<Hobby,Integer> {

    List<Hobby> findByJobSeekerId(Long jobseekerId);
}
