package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.postgresql.sistema1.model.Cliente;


@RepositoryRestResource
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
     
   

    
}
