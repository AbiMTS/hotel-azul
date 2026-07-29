package com.hotelazul.service;

import com.hotelazul.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarUsuarios();

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorCorreo(String correo);

    Usuario guardar(Usuario usuario);

    void eliminar(Long id);
}
