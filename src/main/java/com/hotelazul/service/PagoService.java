package com.hotelazul.service;

import com.hotelazul.entity.Pago;

import java.util.List;
import java.util.Optional;
public interface  PagoService {
    List<Pago> listar();

    Optional<Pago> buscarPorId(Long id);

    Pago guardar(Pago pago);

    void eliminar(Long id);
    List<Pago> buscar(String texto);
}
