package com.jt.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.backend.models.History;

public interface HistoryRepository extends  JpaRepository<History,Long> {
	List<History> findByUserId(Long userId);
}
