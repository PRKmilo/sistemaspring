package com.postgresql.sistema1.model;

import java.math.BigInteger;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private Long ID_USUARIO;
    private String PRIMER_NOMBRE_USUARIO;
    private String SEGUNDO_NOMBRE_USUARIO;
    private String PRIMER_APELLIDO_USUARIO;
    private String PRIMER_SEGUNDO_USUARIO;
    private String DIRECCION_USUARIO;
    private BigInteger TELEFONO_USUARIO;
    private String EMAIL_USUARIO;
    private String PASSWORD_USUARIO;
    private Timestamp CREADO_USUARIO;

}
