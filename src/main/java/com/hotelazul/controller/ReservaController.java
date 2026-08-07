package com.hotelazul.controller;

import com.hotelazul.entity.Reserva;
import com.hotelazul.service.HabitacionService;
import com.hotelazul.service.HuespedService;
import com.hotelazul.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @Autowired
    private HuespedService huespedService;

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/reservas")
    public String listarReservas(
            @RequestParam(required = false) String buscar,
            Model model) {
        if (buscar != null && !buscar.isBlank()) {
            model.addAttribute("reservas",
                    reservaService.buscar(buscar));
        } else {
            model.addAttribute("reservas",
                    reservaService.listar());
        }
        model.addAttribute("buscar", buscar);
        return "reservas/listaReservas";
    }

    @GetMapping("/reservas/nueva")
    public String nuevaReserva(Model model) {

        model.addAttribute("reserva", new Reserva());
        model.addAttribute("huespedes", huespedService.listar());
        model.addAttribute("habitaciones", habitacionService.listar());

        return "reservas/nuevaReserva";
    }

    @PostMapping("/reservas/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva,
                                 Model model) {

        if (reserva.getFechaSalida().isBefore(reserva.getFechaEntrada())) {

            model.addAttribute("error",
                    "La fecha de salida no puede ser menor que la fecha de entrada.");

            model.addAttribute("huespedes", huespedService.listar());
            model.addAttribute("habitaciones", habitacionService.listar());

            return "reservas/nuevaReserva";
        }

        reserva.setFechaReserva(java.time.LocalDate.now());

        reservaService.guardar(reserva);

        return "redirect:/reservas";
    }

    @GetMapping("/reservas/editar/{id}")
    public String editarReserva(@PathVariable Long id, Model model) {

        Reserva reserva = reservaService.buscarPorId(id).orElseThrow();

        model.addAttribute("reserva", reserva);
        model.addAttribute("huespedes", huespedService.listar());
        model.addAttribute("habitaciones", habitacionService.listar());

        return "reservas/editarReserva";
    }

    @GetMapping("/reservas/eliminar/{id}")
    public RedirectView eliminarReserva(@PathVariable Long id) {

        reservaService.eliminar(id);

        return new RedirectView("/reservas");
    }
}
