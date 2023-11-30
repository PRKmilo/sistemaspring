package com.postgresql.sistema1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.postgresql.sistema1.clases.ReturnResponse;
import com.postgresql.sistema1.model.Recaudo;
import com.postgresql.sistema1.repositories.ClienteRepository;
import com.postgresql.sistema1.repositories.FacturaRepository;
import com.postgresql.sistema1.repositories.RecaudoRepository;

@Service
public class RecaudoService {
    private ClienteRepository clienteRepository;
    private FacturaRepository facturaRepository;
    private RecaudoRepository recaudoRepository;

    public RecaudoService(ClienteRepository clienteRepository, FacturaRepository facturaRepository, RecaudoRepository recaudoRepository){
        this.clienteRepository = clienteRepository;
        this.facturaRepository = facturaRepository;
        this.recaudoRepository = recaudoRepository;
    }

    public List<Recaudo> listaRecaudos(){
        return recaudoRepository.findAll();
    }

    public ReturnResponse registrarRecaudo(Recaudo recaudo){
        ReturnResponse res = new ReturnResponse();
        Boolean eCliente =clienteRepository.findById(recaudo.getID_CLIENTE()).isPresent();
        Boolean eFactura = facturaRepository.findById(recaudo.getID_FACTURA()).isPresent();
        if (! eCliente && eFactura){
            res.setStatus(0);
            res.setMensaje("El cliente no esta presente en la base de datos");
        }else if(!eFactura && eCliente){
            res.setStatus(1);
            res.setMensaje("La factura asociada no existe en la base de datos");
        }else if(!eFactura && !eCliente){
            res.setStatus(2);
            res.setMensaje("No existe factura y mensaje asociado a ese recaudo en la base de datos");
        }else{
            recaudoRepository.save(recaudo);
            res.setStatus(3);
            res.setMensaje("Se registro exitosamente el recaudo");
        }
        return res;
    }
}
