package com.postgresql.sistema1.model;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "recaudo")
public class Recaudo {
    @Id
    private Long ID_RECAUDO;
    private short ID_CLIENTE;
    private short ID_FACTURA;
    private int VALOR_RECAUDO;
    private Date FECHA_RECAUDO;
}
