package com.postgresql.sistema1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.postgresql.sistema1.clases.RecaudoForm;
import com.postgresql.sistema1.services.RecaudoService;

//import dto.UsuarioDTO;

@Controller
@SessionAttributes("usuarioDTO")
public class RecaudoController {

    private RecaudoService recaudoService;

    public RecaudoController(RecaudoService recaudoService) {
        this.recaudoService = recaudoService;
    }

    @GetMapping("/ver_recaudo")
    public String mostrarRecaudo(Model model) {
        
        List<Object[]> clientesFactura = recaudoService.ClientesFactura();
        model.addAttribute("clientesFactura", clientesFactura);
        return "tables-data";
    }

    @GetMapping("/ingresar_recaudo")
    public String mostrarFormularioRecaudo(Model model) {
        
        List<Object[]> clientesFactura = recaudoService.ClientesFactura();
    
        model.addAttribute("recaudoForm", new RecaudoForm());
        model.addAttribute("clientesFactura", clientesFactura);
        return "forms-elements";
    }

    @PostMapping("/ingresar_recaudo")
    public String autenticacion_logica(@ModelAttribute("recaudoForm") RecaudoForm recaudoForm,
            @RequestParam(name = "redirect", required = false) String redirect, RedirectAttributes redirectAttributes) {

        // List<Object[]> usuario =
        // usuarioService.obtenerUsuario(loginForm.getUsername(),
        // loginForm.getPassword());

        // UsuarioDTO usuarioDTO = new UsuarioDTO((Long)
        // usuarioArreglo[0],(String)usuarioArreglo[1],new Long[]{(Long)
        // usuarioArreglo[2],(Long) usuarioArreglo[3]});

        redirectAttributes.addFlashAttribute("recaudoForm", recaudoForm);
        return "redirect:/prueba";

    }

    @GetMapping("/prueba")
    public String prueba(Model model, @ModelAttribute("recaudoForm") RecaudoForm recaudoForm) {
        // Info
        // usuarioArreglo[0] = IDUsuario
        // usuarioArreglo[1] = NombreUsuario
        // usuarioArreglo[2....] = Roles
        model.addAttribute("idCliente", recaudoForm.getIdCliente());
        model.addAttribute("idFactura", recaudoForm.getIdFactura());
        model.addAttribute("valorRecaudo", recaudoForm.getValorRecaudo());
        return "principal";
    }

}