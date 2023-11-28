package com.postgresql.sistema1.model;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    private Long ID_ROL;
    private String NOM_ROL;
    private String DESCRIPCION;
    private Timestamp CREATED_AT;

}
