package com.ps.Magazin.controller;

import com.ps.Magazin.dto.ParfumCosDto;
import com.ps.Magazin.dto.ProdusCantitateDto;
import com.ps.Magazin.dto.ProdusComandaAddParfumDTO;
import com.ps.Magazin.dto.ProdusComandaDto;
import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.ProdusComanda;
import com.ps.Magazin.model.User;
import com.ps.Magazin.service.ProdusComandaService;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produsComanda")
@CrossOrigin
public class ProdusComandaController {
    private final ProdusComandaService produsComandaService;

    public ProdusComandaController(ProdusComandaService produsComandaService) {
        this.produsComandaService = produsComandaService;
    }
    @GetMapping("/{id}")
    public ResponseEntity findComandaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produsComandaService.findbyId(id));
    }

    @PutMapping
    public ResponseEntity updateProdusParfum(@RequestBody ProdusComandaAddParfumDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(produsComandaService.updateParfum(dto));
    }
    @PutMapping("/add")
    public ResponseEntity adaugaProdusComanda(@ApiParam(value = "Requires a parfum id and boolean value for cart")@RequestBody ProdusComandaDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(produsComandaService.saveProdusComanda(dto));
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@ApiParam(value = "Requires an existant user")@RequestBody ProdusComanda dto) {
        return ResponseEntity.status(HttpStatus.OK).body(produsComandaService.updateProdusComanda(dto));
    }


}
