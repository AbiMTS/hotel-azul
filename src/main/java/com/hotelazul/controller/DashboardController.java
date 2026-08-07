package com.hotelazul.controller;

import com.hotelazul.repository.HabitacionRepository;
import com.hotelazul.repository.HuespedRepository;
import com.hotelazul.repository.PagoRepository;
import com.hotelazul.repository.ReservaRepository;
import com.hotelazul.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import com.hotelazul.security.CustomUserDetails;
import com.hotelazul.entity.Usuario;

@Controller
public class DashboardController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private HuespedRepository huespedRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {

        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        Usuario usuario = userDetails.getUsuario();

        model.addAttribute("usuario", usuario);

        model.addAttribute("totalHabitaciones", habitacionRepository.count());
        model.addAttribute("totalHuespedes", huespedRepository.count());
        model.addAttribute("totalReservas", reservaRepository.count());
        model.addAttribute("totalPagos", pagoRepository.count());
        model.addAttribute("totalUsuarios", usuarioRepository.count());

        return "dashboard/index";
    }
}
