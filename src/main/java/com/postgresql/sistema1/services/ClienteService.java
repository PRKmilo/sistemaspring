package com.postgresql.sistema1.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.postgresql.sistema1.model.Cliente;
import com.postgresql.sistema1.repositories.ClienteRepository;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listAllClientes(){
        return clienteRepository.findAll();
    }

    public Cliente addCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

   public Boolean existsClient(Long id_cliente){
      Boolean res = clienteRepository.findById(id_cliente).isPresent();
      return res;
   }
    

}
