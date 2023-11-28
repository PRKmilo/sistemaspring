package com.postgresql.sistema1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.postgresql.sistema1.model.Ciudad;
import com.postgresql.sistema1.services.CiudadService;

@Controller
public class CiudadController {

    private CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService){
        this.ciudadService=ciudadService;
    }
    
    @GetMapping("/ciudades")
    @ResponseBody
    public Iterable<Ciudad> mostrarCiudades(){
        return ciudadService.obtenerCiudades();
    }
}
