package com.ldon.covid19.repository;

import com.ldon.covid19.model.CountriesStat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author LucasDonizeti
 */
public interface CountryRepository extends JpaRepository<CountriesStat, Long> {
}
