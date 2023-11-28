package com.postgresql.sistema1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.CollectionUtils;
import com.postgresql.sistema1.clases.LoginForm;
import com.postgresql.sistema1.services.UsuarioService;

@Controller
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
                for (Object[] arrayObjetos : usuario) {
                    for (Object objeto : arrayObjetos) {
                        System.out.println(objeto + "  *");
                    }
                }
                redirectAttributes.addFlashAttribute("usuario", usuario);
                return "redirect:/principal";

            } else {
                System.out.println("Su usuario no tiene ningún rol asignado");
            }

        }

        return "redirect:/login";
    }

    @GetMapping("/principal")
    public String mostrarPrincipal(Model model, @ModelAttribute("usuario") List<Object[]> usuario) {

        String correoUsuario = usuario.isEmpty() ? "" : (String) usuario.get(0)[1];
        model.addAttribute("correoUsuario", correoUsuario);
        return "principal";

    }
}