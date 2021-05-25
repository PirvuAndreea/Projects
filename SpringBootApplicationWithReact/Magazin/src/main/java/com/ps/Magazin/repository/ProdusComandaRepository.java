package com.ps.Magazin.repository;

import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.ProdusComanda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdusComandaRepository extends CrudRepository<ProdusComanda, Long> {

    @Query("SELECT p FROM ProdusComanda p WHERE p.parfum=?1")
    List<ProdusComanda> findParfumisProdusComanda(Parfum parfum);
}
