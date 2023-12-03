package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.postgresql.sistema1.model.Recaudo;
import java.util.List;

public interface RecaudoRepository extends JpaRepository<Recaudo, Long> {

    @Query("SELECT  r.ID_RECAUDO,CONCAT(c.PRIMER_NOMBRE_CLIENTE, ' ', c.SEGUNDO_NOMBRE_CLIENTE, ' ', c.PRIMER_APELLIDO_CLIENTE, ' ', c.SEGUNDO_APELLIDO_CLIENTE) AS nombre , r.ID_FACTURA, r.VALOR_RECAUDO, r.FECHA_RECAUDO from Recaudo r, Cliente c where r.ID_CLIENTE_RECAUDO=c.ID_CLIENTE") 
    List<Object[]> obtenerRecaudos();

    
    @Modifying
    @Query("INSERT INTO Recaudo (ID_CLIENTE_RECAUDO, ID_FACTURA, VALOR_RECAUDO) " +
           "VALUES (:id_cliente, :id_factura, :valor_recaudo)")
    void agregarRecaudos(@Param("id_cliente") short id_cliente,
                        @Param("id_factura") short id_factura,
                        @Param("valor_recaudo") int valor_recaudo);

}
