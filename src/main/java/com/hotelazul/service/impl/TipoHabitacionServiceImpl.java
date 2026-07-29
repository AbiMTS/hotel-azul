package com.hotelazul.service.impl;

import com.hotelazul.entity.TipoHabitacion;
import com.hotelazul.repository.TipoHabitacionRepository;
import com.hotelazul.service.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoHabitacionServiceImpl implements TipoHabitacionService{
    @Autowired
    private TipoHabitacionRepository repository;

    @Override
    public List<TipoHabitacion> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<TipoHabitacion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public TipoHabitacion guardar(TipoHabitacion tipoHabitacion) {
        return repository.save(tipoHabitacion);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
