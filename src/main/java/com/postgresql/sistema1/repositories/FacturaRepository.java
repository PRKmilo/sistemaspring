package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgresql.sistema1.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Short>{
    
}
