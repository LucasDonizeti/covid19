package com.ldon.covid19.repository;

import com.ldon.covid19.model.CityData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author LucasDonizeti
 */
public interface CityDataRepository extends JpaRepository<CityData, String>{
    Page<CityData> findByStateOrderByCity(Pageable pageable, String state);
    Page<CityData> findAll(Pageable pageable);
}
