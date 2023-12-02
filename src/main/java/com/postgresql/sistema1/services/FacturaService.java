package com.postgresql.sistema1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.postgresql.sistema1.repositories.FacturaRepository;
import com.postgresql.sistema1.model.Factura;

@Service
public class FacturaService {

    private FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository){
        this.facturaRepository=facturaRepository;
    }

    public List<Factura> listaFacturas(){
        return facturaRepository.findAll();
    }

    public Factura guardFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    public List<Object[]> ObtenerFactura(){
        return facturaRepository.obtenerFactura();
    }
    
}
