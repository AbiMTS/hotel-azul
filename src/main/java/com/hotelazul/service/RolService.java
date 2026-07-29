package com.hotelazul.service;

import com.hotelazul.entity.Rol;

import java.util.List;
import java.util.Optional;
public interface RolService {

    List<Rol> listarRoles();

    Optional<Rol> buscarPorId(Long id);

    Rol guardar(Rol rol);

    void eliminar(Long id);
}
