package com.ps.Magazin.repository;

import com.ps.Magazin.model.Comanda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends CrudRepository<Comanda, Long> {
    Comanda findByAdresa(String adresa);




}
