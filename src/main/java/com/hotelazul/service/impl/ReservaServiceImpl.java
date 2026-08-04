package com.hotelazul.service.impl;
import com.hotelazul.entity.Reserva;
import com.hotelazul.repository.ReservaRepository;
import com.hotelazul.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository repository;

    @Override
    public List<Reserva> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return repository.save(reserva);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
