package com.postgresql.sistema1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente" )
public class Cliente {
    @Id
    private Long ID_CLIENTE;
    private Long ID_EMPRESA;
    private String NIT_CLIENTE;
    private String RSOCIAL_CLIENTE;
    private Long ID_TIPO_CLIENTE;
    private String PRIMER_NOMBRE_CLIENTE;
    private String SEGUNDO_NOMBRE_CLIENTE;
    private String PRIMER_APELLIDO_CLIENTE;
    private String SEGUNDO_APELLIDO_CLIENTE;
    private String DIR_CLIENTE;
    private int ID_CIUDAD;
    private String CORREO_CLIENTE;
    private String TEL_CLIENTE;
    private String CODPOSTAL_CLIENTE;
    private int CUPOCREDITO_CLIENTE;
    private int SALDO_CLIENTE;
    private int COMPRASMES_CLIENTE;
    private int PAGOSMES_CLIENTE;
    private String ESTADO_CLIENTE;
}
