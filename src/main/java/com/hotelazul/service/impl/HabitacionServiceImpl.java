package com.hotelazul.service.impl;

import com.hotelazul.entity.Habitacion;
import com.hotelazul.repository.HabitacionRepository;
import com.hotelazul.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionServiceImpl implements HabitacionService {
    @Autowired
    private HabitacionRepository repository;

    @Override
    public List<Habitacion> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Habitacion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Habitacion guardar(Habitacion habitacion) {
        return repository.save(habitacion);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

