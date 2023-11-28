package com.postgresql.sistema1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ciudad")
public class Ciudad {
    @Id
    private Long ID_CIUDAD;
    private  String COD_CIUDAD;
    private String NOMBRE_CIUDAD;
    private String ID_DPTO_CIUDAD;
    private Character ESTADO_CIUDAD; 
}
