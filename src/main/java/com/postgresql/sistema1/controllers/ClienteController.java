package com.postgresql.sistema1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.postgresql.sistema1.model.Cliente;
import com.postgresql.sistema1.services.ClienteService;

@Controller
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    @ResponseBody
    public Iterable<Cliente> obtenerClientes(){
        return clienteService.listAllClientes();
    }
}
