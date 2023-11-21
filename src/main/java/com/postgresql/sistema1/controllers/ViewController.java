package com.postgresql.sistema1.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.postgresql.sistema1.clases.LoginForm;


import org.springframework.ui.Model;


@Controller
public class ViewController {


    @GetMapping("/login")
    public String mostrarLogin(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String autenticacion_logica(@ModelAttribute("loginForm") LoginForm loginForm,
                                       @RequestParam(name = "redirect", required = false) String redirect,
                                       RedirectAttributes redirectAttributes){

        
        System.out.println("Este es el username "+loginForm.getUsername());
        redirectAttributes.addFlashAttribute("loginForm", loginForm);
       
        return "redirect:/principal";
    } 

    @GetMapping("/principal")
    public String mostrarPrincipal(Model model,@ModelAttribute("loginForm") LoginForm loginForm){
        System.out.println("este es el loginform de principal"+loginForm.getUsername());
        
        return "principal";
    }
}