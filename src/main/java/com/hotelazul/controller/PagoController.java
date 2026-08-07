package com.hotelazul.controller;

import com.hotelazul.entity.Pago;
import com.hotelazul.service.PagoService;
import com.hotelazul.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;

@Controller
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/pagos")
    public String listarPagos(
            @RequestParam(required = false) String buscar,
            Model model) {
        if (buscar != null && !buscar.isBlank()) {
            model.addAttribute("pagos",
                    pagoService.buscar(buscar));
        } else {
            model.addAttribute("pagos",
                    pagoService.listar());
        }

        model.addAttribute("buscar", buscar);

        return "pagos/listaPagos";
    }

    @GetMapping("/pagos/nuevo")
    public String nuevoPago(Model model){

        Pago pago = new Pago();
        pago.setFechaPago(LocalDate.now());

        model.addAttribute("pago", pago);
        model.addAttribute("reservas", reservaService.listar());

        return "pagos/nuevoPago";
    }

    @PostMapping("/pagos/guardar")
    public String guardarPago(@ModelAttribute Pago pago){

        pagoService.guardar(pago);

        return "redirect:/pagos";
    }

    @GetMapping("/pagos/editar/{id}")
    public String editarPago(@PathVariable Long id, Model model){

        Pago pago = pagoService.buscarPorId(id).orElseThrow();

        model.addAttribute("pago", pago);
        model.addAttribute("reservas", reservaService.listar());

        return "pagos/editarPago";
    }

    @GetMapping("/pagos/eliminar/{id}")
    public RedirectView eliminarPago(@PathVariable Long id){

        pagoService.eliminar(id);

        return new RedirectView("/pagos");
    }
}
