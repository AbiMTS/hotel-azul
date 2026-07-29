package com.hotelazul.service.impl;

import com.hotelazul.entity.Huesped;
import com.hotelazul.repository.HuespedRepository;
import com.hotelazul.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuespedServiceImpl implements HuespedService{
    @Autowired
    private HuespedRepository repository;

    @Override
    public List<Huesped> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Huesped> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Huesped guardar(Huesped huesped) {
        return repository.save(huesped);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
