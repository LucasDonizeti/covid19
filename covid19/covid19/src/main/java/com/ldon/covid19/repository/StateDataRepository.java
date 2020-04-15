package com.ldon.covid19.repository;

import com.ldon.covid19.model.StateData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author LucasDonizeti
 */
public interface StateDataRepository extends JpaRepository<StateData, String> {
    List<StateData> findByOrderByState();
}
