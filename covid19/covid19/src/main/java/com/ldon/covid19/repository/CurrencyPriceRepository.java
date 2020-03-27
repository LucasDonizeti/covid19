package com.ldon.covid19.repository;

import com.ldon.covid19.model.CurrencyPrice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author LucasDonizeti
 */
public interface CurrencyPriceRepository extends JpaRepository<CurrencyPrice, String> {
}
