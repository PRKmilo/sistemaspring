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
import org.springframework.util.CollectionUtils;
import com.postgresql.sistema1.clases.LoginForm;
import com.postgresql.sistema1.services.UsuarioService;

import dto.UsuarioDTO;

@Controller
@SessionAttributes("usuarioDTO")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "pages-login";
    }

    @PostMapping("/login")
    public String autenticacion_logica(@ModelAttribute("loginForm") LoginForm loginForm,
            @RequestParam(name = "redirect", required = false) String redirect, RedirectAttributes redirectAttributes) {

        List<Object[]> usuario = usuarioService.obtenerUsuario(loginForm.getUsername(), loginForm.getPassword());
        UsuarioDTO usuarioDTO= null;

        if (!CollectionUtils.isEmpty(usuario)) {

            for(Object[] array: usuario){
               usuarioDTO= new UsuarioDTO((String) array[0], (Long) array[1], (String) array[2]);
            }
  
                redirectAttributes.addFlashAttribute("usuarioDTO", usuarioDTO);
                return "redirect:/principal";

            } else {
                System.out.println("Su usuario no tiene ningún rol asignado");
            }

        return "redirect:/login";
    }

    @GetMapping("/principal")
    public String mostrarPrincipal(Model model, @ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO) {

        model.addAttribute("usuarioDTO", usuarioDTO);
        return "index";
    }
}