package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgresql.sistema1.model.Recaudo;

public interface RecaudoRepository extends JpaRepository<Recaudo, Long> {
    
}
