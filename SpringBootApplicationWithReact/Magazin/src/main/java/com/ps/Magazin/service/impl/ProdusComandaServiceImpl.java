package com.ps.Magazin.service.impl;

import com.ps.Magazin.dto.ProdusCantitateDto;
import com.ps.Magazin.dto.ProdusComandaAddParfumDTO;
import com.ps.Magazin.dto.ProdusComandaDto;
import com.ps.Magazin.dto.ProdusComandaSuccsesDto;
import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.ProdusComanda;
import com.ps.Magazin.model.User;
import com.ps.Magazin.repository.ParfumRepository;
import com.ps.Magazin.repository.ProdusComandaRepository;
import com.ps.Magazin.repository.UserRepository;
import com.ps.Magazin.service.ProdusComandaService;
import org.springframework.stereotype.Service;

@Service
public class ProdusComandaServiceImpl implements ProdusComandaService {
    private final ProdusComandaRepository produsComandaRepository;
    private final ParfumRepository parfumRepository;
    private final UserRepository userRepository;

    public ProdusComandaServiceImpl(ProdusComandaRepository produsComandaRepository, ParfumRepository parfumRepository, UserRepository userRepository) {
        this.produsComandaRepository = produsComandaRepository;
        this.parfumRepository = parfumRepository;
        this.userRepository = userRepository;
    }


    @Override
    public ProdusComanda findbyId(Long id) {
        return produsComandaRepository.findById(id).orElseThrow();
    }

    @Override
    public ProdusComanda updateParfum(ProdusComandaAddParfumDTO dto) {
       ProdusComanda produsComanda = produsComandaRepository.findById(dto.getProdusID()).get();
       Parfum parfum = parfumRepository.findById(dto.getParfumID()).get();
       if(produsComanda.getParfum()==null) {
           produsComanda.setParfum(parfum);
           produsComandaRepository.save(produsComanda);
       }
           return produsComanda;

    }

    @Override
    public ProdusComandaSuccsesDto saveProdusComanda(ProdusComandaDto dto) {
        ProdusComandaSuccsesDto produsComandaSuccsesDto = new ProdusComandaSuccsesDto();
        Parfum parfum = parfumRepository.findById(dto.getIdParfum()).get();
        User user = userRepository.findById(dto.getIdUser()).get();
        ProdusComanda produsComanda = new ProdusComanda();
        produsComanda.setCantitate(1);
        produsComanda.setValoare( parfum.getPret());
        produsComanda.setParfum(parfum);
        produsComandaRepository.save(produsComanda);
        produsComandaSuccsesDto.setIdComanda(produsComanda.getId());
        user.getProduse().add(produsComanda);



        userRepository.save(user);
        System.out.println(produsComanda);
        System.out.println(user);
        System.out.println(parfum);
        return produsComandaSuccsesDto;
    }

    @Override
    public ProdusComanda updateProdusComanda(ProdusComanda dto) {
        ProdusComanda produsComanda = produsComandaRepository.findById(dto.getId()).get();
        Parfum parfum = produsComanda.getParfum();
        produsComanda.setValoare(parfum.getPret()*dto.getCantitate());
        produsComanda.setCantitate(dto.getCantitate());
        produsComanda.setParfum(dto.getParfum());
        if(dto.getCantitate() > parfum.getCantitate() )
        {
            System.out.println("Cantitatea introdusa este indisponibila");
            return null;
        }
        return produsComandaRepository.save(produsComanda);
    }


    /*@Override
    public ProdusComanda updateProdusComanda(ProdusCantitateDto dto) {
        ProdusComanda produsComanda = produsComandaRepository.findById(dto.getIdProdus()).get();
        produsComanda.setCantitate(dto.getCantitate());
        Float pret = produsComanda.getParfum().getPret();
        produsComanda.setValoare(pret*dto.getCantitate());
        Parfum parfum = produsComanda.getParfum();
        if(dto.getCantitate()>parfum.getCantitate())
        {
            //aruncam eroare
        }
        else {
            parfum.setCantitate(parfum.getCantitate() - dto.getCantitate());
        }
        parfumRepository.save(parfum);
        produsComandaRepository.save(produsComanda);
        System.out.println(produsComanda);

        return produsComanda;
    }
*/

}
