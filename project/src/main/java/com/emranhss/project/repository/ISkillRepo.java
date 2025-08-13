package com.emranhss.project.repository;

import com.emranhss.project.entity.Hobby;
import com.emranhss.project.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISkillRepo extends JpaRepository<Skill,Integer> {
    List<Skill> findByJobSeekerId(Long jobseekerId);
}
