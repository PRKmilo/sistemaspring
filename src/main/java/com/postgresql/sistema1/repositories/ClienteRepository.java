package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import com.postgresql.sistema1.model.Cliente;


@RepositoryRestResource
public interface ClienteRepository  extends JpaRepository<Cliente, Short>{
     
   @Query("SELECT c.ID_CLIENTE  FROM Cliente c WHERE c.NIT_CLIENTE = :nitCliente ") 
   List<Object[]> findByNIT_CLIENTE(@Param("nitCliente") String nitCliente);

    
}
