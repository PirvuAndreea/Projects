package com.ps.Magazin.service.impl;

import com.ps.Magazin.model.Comanda;
import com.ps.Magazin.repository.ComandaRepository;
import com.ps.Magazin.service.ComandaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaServiceImpl implements ComandaService {

    private final ComandaRepository comandaRepository;

    public ComandaServiceImpl(ComandaRepository comandaRepository) {
        this.comandaRepository = comandaRepository;
    }

    @Override
    public Comanda findById(Long id) {
        return comandaRepository.findById(id).get();
    }

    @Override
    public void save(Comanda comanda) {
        comandaRepository.save(comanda);

    }

    @Override
    public void delete(Long id) {
        comandaRepository.deleteById(id);

    }

    @Override
    public List<Comanda> listAll() {
        return (List<Comanda>) comandaRepository.findAll();
    }
}
