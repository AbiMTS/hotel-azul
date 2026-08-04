package com.hotelazul.controller;

import com.hotelazul.entity.Usuario;
import com.hotelazul.service.RolService;
import com.hotelazul.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model){

        model.addAttribute("usuarios", usuarioService.listarUsuarios());

        return "usuarios/listaUsuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String nuevoUsuario(Model model){

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.listarRoles());

        return "usuarios/nuevoUsuario";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {

        if (usuario.getId() != null) {
            Usuario usuarioBD = usuarioService.buscarPorId(usuario.getId()).orElseThrow();
            if (usuario.getPassword() == null || usuario.getPassword().isBlank()) {
                usuario.setPassword(usuarioBD.getPassword());
            } else {
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            }
        } else {

            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model){

        Usuario usuario = usuarioService.buscarPorId(id).orElseThrow();

        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", rolService.listarRoles());

        return "usuarios/editarUsuario";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public RedirectView eliminarUsuario(@PathVariable Long id){

        usuarioService.eliminar(id);

        return new RedirectView("/usuarios");
    }

}
