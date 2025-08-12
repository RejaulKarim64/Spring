package com.emranhss.project.repository;

import com.emranhss.project.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrainingRepo extends JpaRepository<Hobby,Integer> {
}
