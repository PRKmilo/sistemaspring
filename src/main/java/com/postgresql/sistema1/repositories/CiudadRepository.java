package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgresql.sistema1.model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long>{
    
}
