package com.ps.Magazin.repository;

import com.ps.Magazin.model.Parfum;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ParfumRepository extends CrudRepository<Parfum, Long> {
    Parfum findFirstByCantitate(Integer cantitate);
    Parfum findFirstByPret(Float pret);
    Parfum findFirstByProducator(String producator);
    Parfum findFirstByNumeparfum(String numeparfum);
    List<Parfum>findAllByNumeparfum(String numeparfum);
    List<Parfum> findAllById(Long id);
    @Query("SELECT p FROM Parfum p WHERE CONCAT(p.numeparfum, ' ', p.producator, ' ', p.anfabricatie, ' ', p.tara, ' ' , p.genparfum, ' ' , p.continut, ' ', p.pret, ' ', p.tip) LIKE %?1%")
    List<Parfum> findAll(String keyword);
    Parfum save(Parfum parfum);
    void delete(Parfum parfum);
    @Query("SELECT p FROM Parfum p WHERE p.incos = true")
    List<Parfum> findAllByIncosTrue();




    //@Query(SELECT * FROM parfum)
    //Parfum findByParfum();
}
