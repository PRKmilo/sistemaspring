package com.postgresql.sistema1.clases;

import lombok.Data;

@Data
public class ReturnResponse {
    private  int status;
    private String mensaje;
    private int newValue;
    private short ID_FACTURA_cambiada;
}