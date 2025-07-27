package com.emranhss.project.repository;

import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

}
