package com.emranhss.project.repository;

import com.emranhss.project.entity.Hobby;
import com.emranhss.project.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILanguageRepo extends JpaRepository<Language,Integer> {

    List<Language> findByJobSeekerId(Long jobseekerId);
}
