package com.ps.Magazin.service;

import com.ps.Magazin.model.Parfum;
import org.springframework.stereotype.Component;

@Component
public interface ParfumService  {
    Parfum findbyId(Long id);
    Parfum updateParfum(Parfum dto);
    void delete(Long id);
    boolean delete(Parfum parfum);
    Parfum findbyNumeParfum(String numeparfum);
    Parfum findbyProducator(String producator);
}
