package com.ps.Magazin.service;

import com.ps.Magazin.dto.ComandaDto;
import com.ps.Magazin.dto.ComandaSuccesDto;
import com.ps.Magazin.dto.UserDto;
import com.ps.Magazin.model.Comanda;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ComandaService {
    Comanda findById(Long id);
    void save(Comanda comanda);
    void delete(Long id);
    List<Comanda> listAll();
    List<Comanda> findComandaByEmail(String email);

    Comanda findByAdresa(String adresa);
    ComandaSuccesDto save(ComandaDto comandaDto);


}
