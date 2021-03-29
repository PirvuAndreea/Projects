package com.ps.Magazin.service;

import com.ps.Magazin.model.Comanda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ComandaService {
    Comanda findById(Long id);
    void save(Comanda comanda);
    void delete(Long id);
    public List<Comanda> listAll();

}
