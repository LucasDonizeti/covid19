package com.ldon.covid19.repository;

import com.ldon.covid19.model.CountriesStat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author LucasDonizeti
 */
public interface CountryRepository extends JpaRepository<CountriesStat, Long> {
    List<CountriesStat> findByCountry(String country);
    List<CountriesStat> findByOrderByCasesDesc();
}
