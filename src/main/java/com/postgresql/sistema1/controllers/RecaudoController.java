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
import com.postgresql.sistema1.model.Recaudo;

//import dto.UsuarioDTO;

@Controller
@SessionAttributes("usuarioDTO")
public class RecaudoController {

    private RecaudoService recaudoService;

    public RecaudoController(RecaudoService recaudoService) {
        this.recaudoService = recaudoService;
    }

    @GetMapping("/consultar_recaudo")
    public String mostrarRecaudo(Model model) {

        List<Object[]> recaudos = recaudoService.ObtenerRecaudos();

        model.addAttribute("recaudos", recaudos);
        return "consulta-recaudo";
    }

    @PostMapping("/ingresar_datos_recaudo")
    public String mostrarFormularioRecaudo(@RequestParam("idCliente") short idCliente,
            @RequestParam("idFactura") short idFactura, @RequestParam("nombreCliente") String nombreCliente,
            Model model) {
        model.addAttribute("idCliente", idCliente);
        model.addAttribute("idFactura", idFactura);
        model.addAttribute("nombreCliente", nombreCliente);
        model.addAttribute("recaudoForm", new RecaudoForm());
        return "forms-elements";
    }

    @PostMapping("/ingresar_recaudo")
    public String autenticacion_logica(@ModelAttribute("recaudoForm") RecaudoForm recaudoForm,
            @RequestParam(name = "redirect", required = false) String redirect, RedirectAttributes redirectAttributes) {

        // Metodo de Cami
        Recaudo recaudo = new Recaudo();
        recaudo.setID_CLIENTE_RECAUDO((short) recaudoForm.getIdCliente());
        recaudo.setID_FACTURA((short) recaudoForm.getIdFactura());
        recaudo.setVALOR_RECAUDO(recaudoForm.getValorRecaudo());
        //recaudoService.registrarRecaudo(recaudo, null, null);
 
        // Registro en la base de datos 
        recaudoService.agregarRecaudosConTransaccion((short) recaudoForm.getIdCliente(), (short) recaudoForm.getIdFactura(), recaudoForm.getValorRecaudo());

        redirectAttributes.addFlashAttribute("recaudoForm", recaudoForm);
        return "redirect:/principal";

    }

}