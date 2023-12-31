package com.postgresql.sistema1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.postgresql.sistema1.services.FacturaService;

import dto.UsuarioDTO;

//import dto.UsuarioDTO;

@Controller
@SessionAttributes("usuarioDTO")
public class FacturaController {

    private FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping("/consultar_factura")
    public String mostrarFactura(Model model, @ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO) {
        
        List<Object[]> facturas = facturaService.ObtenerFactura();
           
        model.addAttribute("facturas", facturas);
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "consulta-factura";
    }

  
}