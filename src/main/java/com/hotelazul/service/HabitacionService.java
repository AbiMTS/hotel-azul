package com.hotelazul.service;
import com.hotelazul.entity.Habitacion;

import java.util.List;
import java.util.Optional;

public interface HabitacionService {
    List<Habitacion> listar();

    Optional<Habitacion> buscarPorId(Long id);

    Habitacion guardar(Habitacion habitacion);

    void eliminar(Long id);
}
