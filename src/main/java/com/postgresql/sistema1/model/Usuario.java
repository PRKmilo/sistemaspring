package com.postgresql.sistema1.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private long id;
    private String nombre;
    private String contrasena;
    private Date fecha_nacimiento;
    private String documento_identidad;
    private String tipo_documento;
}
