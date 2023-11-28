package com.postgresql.sistema1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario_rol")
public class Usuario_rol {
    @Id
    private Long ID_USUARIO_ROL;
    private int ID_USUARIO;
    private int ID_ROL;
}
