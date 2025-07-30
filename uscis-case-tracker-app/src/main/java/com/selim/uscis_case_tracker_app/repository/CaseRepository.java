package com.selim.uscis_case_tracker_app.repository;

import com.selim.uscis_case_tracker_app.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {
    List<Case> findByUserId(Long userId);
}
