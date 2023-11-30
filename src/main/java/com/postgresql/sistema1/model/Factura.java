package com.postgresql.sistema1.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    private Long ID_FACTURA;
    private int ID_CLIENTE;
    private Date FECHA_FACTURA;
    private int SUBTOTAL_FACTURA;
    private int VALOR_IVA;
    private int TOTAL_FACTURA;
}
