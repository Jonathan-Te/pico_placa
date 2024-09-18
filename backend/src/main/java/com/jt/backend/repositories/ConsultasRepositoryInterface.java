package com.jt.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.backend.models.Consulta;

public interface ConsultasRepositoryInterface extends JpaRepository<Consulta, Long>{

}
