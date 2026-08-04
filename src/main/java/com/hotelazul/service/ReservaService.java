package com.hotelazul.service;

import com.hotelazul.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<Reserva> listar();

    Optional<Reserva> buscarPorId(Long id);

    Reserva guardar(Reserva reserva);

    void eliminar(Long id);
}
