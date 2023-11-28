package com.postgresql.sistema1.services;

import org.springframework.stereotype.Service;

import com.postgresql.sistema1.model.Ciudad;
import com.postgresql.sistema1.repositories.CiudadRepository;

@Service
public class CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository){

        this.ciudadRepository = ciudadRepository;

    }

    public Iterable<Ciudad> obtenerCiudades(){
        return ciudadRepository.findAll();
    }
}
