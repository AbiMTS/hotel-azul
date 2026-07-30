package com.hotelazul.controller;
import com.hotelazul.entity.Habitacion;
import com.hotelazul.service.HabitacionService;
import com.hotelazul.service.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HabitacionController {


    @Autowired
    private HabitacionService habitacionService;

    @Autowired
    private TipoHabitacionService tipoHabitacionService;

    @GetMapping("/habitaciones")
    public String listarHabitaciones(Model model) {

        model.addAttribute("habitaciones", habitacionService.listar());

        return "habitaciones/lista";
    }

    @GetMapping("/habitaciones/nueva")
    public String nuevaHabitacion(Model model) {

        model.addAttribute("habitacion", new Habitacion());

        model.addAttribute("tiposHabitacion",
                tipoHabitacionService.listar());

        return "habitaciones/nuevaHabitacion";
    }


    @PostMapping("/habitaciones/guardar")
    public String guardarHabitacion(@ModelAttribute Habitacion habitacion,
                                    org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {

        habitacionService.guardar(habitacion);

        redirectAttributes.addFlashAttribute("mensaje",
                "✅ Habitación guardada correctamente.");

        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/editar/{id}")
    public String editarHabitacion(@PathVariable Long id, Model model) {

        Habitacion habitacion = habitacionService.buscarPorId(id).orElseThrow();

        model.addAttribute("habitacion", habitacion);
        model.addAttribute("tiposHabitacion", tipoHabitacionService.listar());

        return "habitaciones/editarHabitacion";
    }

    @GetMapping("/habitaciones/eliminar/{id}")
    public RedirectView eliminarHabitacion(@PathVariable Long id) {

        habitacionService.eliminar(id);

        return new RedirectView("/habitaciones");
    }
}
