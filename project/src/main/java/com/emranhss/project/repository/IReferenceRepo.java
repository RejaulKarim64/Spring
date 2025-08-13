package com.emranhss.project.repository;

import com.emranhss.project.entity.Hobby;
import com.emranhss.project.entity.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReferenceRepo extends JpaRepository<Reference,Integer> {
    List<Reference> findByJobSeekerId(Long jobseekerId);
}
