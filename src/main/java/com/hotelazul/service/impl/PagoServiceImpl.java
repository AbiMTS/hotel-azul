package com.hotelazul.service.impl;

import com.hotelazul.entity.Pago;
import com.hotelazul.repository.PagoRepository;
import com.hotelazul.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {
    @Autowired
    private PagoRepository repository;

    @Override
    public List<Pago> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Pago> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Pago guardar(Pago pago) {
        return repository.save(pago);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
