package com.hotelazul.service;
import com.hotelazul.entity.Huesped;

import java.util.List;
import java.util.Optional;
public interface HuespedService {
    List<Huesped> listar();
    Optional<Huesped> buscarPorId(Long id);
    Huesped guardar(Huesped huesped);
    void eliminar(Long id);
    List<Huesped> buscar(String texto);
}
