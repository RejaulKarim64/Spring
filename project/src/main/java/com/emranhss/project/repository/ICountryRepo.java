package com.emranhss.project.repository;

import com.emranhss.project.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepo extends JpaRepository<Country, Integer> {
}
