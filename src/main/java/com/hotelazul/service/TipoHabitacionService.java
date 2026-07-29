package com.hotelazul.service;

import com.hotelazul.entity.TipoHabitacion;

import java.util.List;
import java.util.Optional;

public interface  TipoHabitacionService {
    List<TipoHabitacion> listar();

    Optional<TipoHabitacion> buscarPorId(Long id);

    TipoHabitacion guardar(TipoHabitacion tipoHabitacion);

    void eliminar(Long id);

}
