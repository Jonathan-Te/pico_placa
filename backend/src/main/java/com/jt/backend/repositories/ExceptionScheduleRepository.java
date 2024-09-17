package com.jt.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.backend.models.ExceptionSchedule;

public interface ExceptionScheduleRepository extends JpaRepository<ExceptionSchedule, Integer> {

}
