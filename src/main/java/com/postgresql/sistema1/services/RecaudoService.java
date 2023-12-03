package com.postgresql.sistema1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.postgresql.sistema1.clases.ReturnResponse;
import com.postgresql.sistema1.model.Cliente;
import com.postgresql.sistema1.model.Factura;
import com.postgresql.sistema1.model.Recaudo;
import com.postgresql.sistema1.repositories.ClienteRepository;
import com.postgresql.sistema1.repositories.FacturaRepository;
import com.postgresql.sistema1.repositories.RecaudoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.hibernate.Session;

@Service
public class RecaudoService {
    private ClienteRepository clienteRepository;
    private FacturaRepository facturaRepository;
    private RecaudoRepository recaudoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public RecaudoService(ClienteRepository clienteRepository, FacturaRepository facturaRepository,
            RecaudoRepository recaudoRepository) {
        this.clienteRepository = clienteRepository;
        this.facturaRepository = facturaRepository;
        this.recaudoRepository = recaudoRepository;
    }

    public void agregarRecaudosConTransaccion(short idCliente, short idFactura, int valorRecaudo) { 
        
        Session session = entityManager.unwrap(Session.class);

        try {
            // Realizar operaciones dentro de la transacción
            recaudoRepository.agregarRecaudos(idCliente, idFactura, valorRecaudo);
        } catch (Exception e) {
            // Manejar cualquier excepción
            e.printStackTrace(); // O manejar de acuerdo a tus necesidades
        }
    }

    public void AgregarRecaudos(short id_cliente, short id_factura, int valor_recaudo) {
        recaudoRepository.agregarRecaudos(id_cliente, id_factura, valor_recaudo);
    }

    public List<Object[]> ObtenerRecaudos() {
        return recaudoRepository.obtenerRecaudos();
    }

    public List<Recaudo> listaRecaudos() {
        return recaudoRepository.findAll();
    }

    public ReturnResponse registrarRecaudo(Recaudo recaudo, Factura factura, Cliente cliente) {
        ReturnResponse res = new ReturnResponse();
        Boolean eCliente = Boolean.valueOf(clienteRepository.findByNIT_CLIENTE(cliente.getNIT_CLIENTE()).isEmpty());
        Boolean eFactura = facturaRepository.findById(recaudo.getID_FACTURA()).isPresent();
        if (!eCliente && eFactura) {
            res.setStatus(0);
            clienteRepository.save(cliente);
            recaudoRepository.save(recaudo);
        } else if (!eFactura && eCliente) {
            res.setStatus(1);
            facturaRepository.save(factura);
        } else if (!eFactura && !eCliente) {
            facturaRepository.save(factura);
            clienteRepository.save(cliente);
        } else {
            res.setStatus(3);
            res.setMensaje("Se registro exitosamente el recaudo");
        }
        recaudoRepository.save(recaudo);
        res.setNewValue(calculoSaldo(recaudo.getVALOR_RECAUDO(), factura.getTOTAL_FACTURA()));
        res.setID_FACTURA_cambiada(factura.getID_FACTURA());
        return res;
    }

    public int calculoSaldo(int recaudoValue, int valorFactura) {
        return valorFactura - recaudoValue;
    }

}