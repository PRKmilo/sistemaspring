package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.postgresql.sistema1.model.Recaudo;
import java.util.List;

public interface RecaudoRepository extends JpaRepository<Recaudo, Long> {
    
    @Query("SELECT c.ID_CLIENTE, CONCAT(c.PRIMER_NOMBRE_CLIENTE, ' ', c.SEGUNDO_NOMBRE_CLIENTE, ' ', c.PRIMER_APELLIDO_CLIENTE, ' ', c.SEGUNDO_APELLIDO_CLIENTE) AS nombre FROM Cliente c, Factura f WHERE c.ID_CLIENTE IN (f.ID_CLIENTE) AND f.SUBTOTAL_FACTURA > 0") 
    List<Object[]> clientesFactura();

}
