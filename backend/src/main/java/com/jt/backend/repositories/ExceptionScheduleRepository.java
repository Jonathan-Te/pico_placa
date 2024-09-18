package com.jt.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.backend.models.ExceptionSchedule;
import com.jt.backend.models.RestrictionSchedule;

public interface ExceptionScheduleRepository extends JpaRepository<ExceptionSchedule, Long> {
	List<ExceptionSchedule> findByUserId(Long userId);
}
