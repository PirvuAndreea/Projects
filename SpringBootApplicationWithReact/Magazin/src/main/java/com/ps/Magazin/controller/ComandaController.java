package com.ps.Magazin.controller;

import com.ps.Magazin.dto.ComandaDto;
import com.ps.Magazin.dto.UserDto;
import com.ps.Magazin.service.ComandaService;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comanda")
@CrossOrigin
public class ComandaController {

    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }
    @GetMapping("/{adresa}")
    public ResponseEntity findComandaByAdresa(@PathVariable String adresa){
        return ResponseEntity.status(HttpStatus.OK).body(comandaService.findByAdresa(adresa));
    }
    @PostMapping("/save")
    public ResponseEntity saveNewOrder(@ApiParam(value = "Requires a new order")@RequestBody ComandaDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(comandaService.save(dto));
    }
    @GetMapping()
    public ResponseEntity findAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(comandaService.listAll());
    }





}
