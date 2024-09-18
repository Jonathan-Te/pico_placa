package com.jt.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.backend.models.RestrictionSchedule;

public interface RestrictionScheduleRepository extends JpaRepository<RestrictionSchedule, Long>{
	List<RestrictionSchedule> findByUserId(Long userId);
}
