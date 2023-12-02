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

        if (!CollectionUtils.isEmpty(usuario)) {

            List<Object[]> roles = usuarioService.obtenerRolesUsuario(loginForm.getUsername(), loginForm.getPassword());

            if (!CollectionUtils.isEmpty(roles)) {

                usuario.addAll(roles);

                int totalElementos = 0;
                for (Object[] array : usuario) {
                    totalElementos += array.length;
                }

                Object[] usuarioArreglo = new Object[totalElementos];
                int contador = 0;
                for (Object[] array : usuario) {
                    for (Object objeto : array) {
                        usuarioArreglo[contador++] = objeto;
                    }
                }

                UsuarioDTO usuarioDTO = new UsuarioDTO((Long) usuarioArreglo[0],(String)usuarioArreglo[1],new Long[]{(Long) usuarioArreglo[2],(Long) usuarioArreglo[3]});
  
                redirectAttributes.addFlashAttribute("usuarioDTO", usuarioDTO);
                return "redirect:/principal";

            } else {
                System.out.println("Su usuario no tiene ningún rol asignado");
            }
        }

        return "redirect:/login";
    }

    @GetMapping("/principal")
    public String mostrarPrincipal(Model model, @ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO) {
        // Info
        // usuarioArreglo[0] = IDUsuario
        // usuarioArreglo[1] = NombreUsuario
        // usuarioArreglo[2....] = Roles
        model.addAttribute("nombreUsuario", usuarioDTO.getNombreUsuario());
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "index";
    }
}