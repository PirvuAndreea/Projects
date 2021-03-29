package com.ps.Magazin.repository;

import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.ProdusComanda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdusComandaRepository extends CrudRepository<ProdusComanda, Long> {

    @Query("SELECT p.id FROM ProdusComanda p WHERE p.parfum=?1")
    Long findParfumisProdusComanda(Parfum parfum);
}
