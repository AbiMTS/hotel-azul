package com.hotelazul.controller;
import com.hotelazul.entity.Huesped;
import com.hotelazul.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HuespedController {

    @Autowired
    private HuespedService huespedService;

    @GetMapping("/huespedes")
    public String listarHuespedes(Model model){

        model.addAttribute("huespedes", huespedService.listar());

        return "huespedes/listaHuespedes";
    }

    @GetMapping("/huespedes/nuevo")
    public String nuevoHuesped(Model model){

        model.addAttribute("huesped", new Huesped());

        return "huespedes/nuevoHuesped";
    }

    @PostMapping("/huespedes/guardar")
    public String guardarHuesped(@ModelAttribute Huesped huesped){

        huespedService.guardar(huesped);

        return "redirect:/huespedes";
    }

    @GetMapping("/huespedes/editar/{id}")
    public String editarHuesped(@PathVariable Long id, Model model){

        Huesped huesped = huespedService.buscarPorId(id).orElseThrow();

        model.addAttribute("huesped", huesped);

        return "huespedes/editarHuesped";
    }

    @GetMapping("/huespedes/eliminar/{id}")
    public RedirectView eliminarHuesped(@PathVariable Long id){

        huespedService.eliminar(id);

        return new RedirectView("/huespedes");
    }
}
