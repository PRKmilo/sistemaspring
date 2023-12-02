package com.postgresql.sistema1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.postgresql.sistema1.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Short>{


    @Query("select  f.ID_CLIENTE,  concat(c.PRIMER_NOMBRE_CLIENTE, ' ', c.SEGUNDO_NOMBRE_CLIENTE, ' ', c.PRIMER_APELLIDO_CLIENTE, ' ', c.SEGUNDO_APELLIDO_CLIENTE) as NOMBRE, f.ID_FACTURA, f.FECHA_FACTURA, f.SUBTOTAL_FACTURA, f.VALOR_IVA, f.TOTAL_FACTURA from Factura f, Cliente c where f.ID_CLIENTE=c.ID_CLIENTE") 
    List<Object[]> obtenerFactura();
    
}
