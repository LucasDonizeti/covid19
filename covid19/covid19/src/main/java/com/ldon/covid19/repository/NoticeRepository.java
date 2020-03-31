package com.ldon.covid19.repository;

import com.ldon.covid19.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author LucasDonizeti
 */
public interface NoticeRepository extends JpaRepository<Notice, String> {
    public List<Notice> findByOrderByTimestampDesc();
}

