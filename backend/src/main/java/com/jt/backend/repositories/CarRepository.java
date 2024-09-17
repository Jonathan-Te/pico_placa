package com.jt.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.backend.models.Car;

public interface CarRepository extends  JpaRepository<Car,Integer>{
	List<Car> findByUserId(Long userId);

}
