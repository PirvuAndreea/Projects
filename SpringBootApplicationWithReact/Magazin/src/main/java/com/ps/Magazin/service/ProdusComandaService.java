package com.ps.Magazin.service;

import com.ps.Magazin.dto.ProdusCantitateDto;
import com.ps.Magazin.dto.ProdusComandaAddParfumDTO;
import com.ps.Magazin.dto.ProdusComandaDto;
import com.ps.Magazin.dto.ProdusComandaSuccsesDto;
import com.ps.Magazin.model.ProdusComanda;
import com.ps.Magazin.model.User;
import org.springframework.stereotype.Component;

@Component
public interface ProdusComandaService {

    ProdusComanda updateParfum (ProdusComandaAddParfumDTO dto);
    ProdusComandaSuccsesDto saveProdusComanda(ProdusComandaDto dto);
    //ProdusComanda updateProdusComanda(ProdusCantitateDto dto);
    ProdusComanda updateProdusComanda(ProdusComanda dto);
    ProdusComanda findbyId(Long id);

}
