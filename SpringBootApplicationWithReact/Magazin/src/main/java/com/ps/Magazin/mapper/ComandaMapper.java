package com.ps.Magazin.mapper;

import com.ps.Magazin.dto.ComandaDto;

import com.ps.Magazin.model.Comanda;


public class ComandaMapper {


    public static ComandaDto mapModelToDto(Comanda comanda)
    {
        ComandaDto comandaDto = new ComandaDto();
        comandaDto.setNume(comanda.getNume());
        comandaDto.setPrenume(comanda.getPrenume());
        comandaDto.setOras(comanda.getOras());
        comandaDto.setAdresa(comanda.getAdresa());
        comandaDto.setEmail(comanda.getEmail());
        comandaDto.setNrtelefon(comanda.getNrtelefon());
        comandaDto.setCodpostal(comanda.getCodpostal());
        return comandaDto;

    }

    public static Comanda mapDtoToModel(ComandaDto comandaDto)
    {
        Comanda comanda = new Comanda();
        comanda.setNume(comandaDto.getNume());
        comanda.setPrenume(comandaDto.getPrenume());
        comanda.setOras(comandaDto.getOras());
        comanda.setAdresa(comandaDto.getAdresa());
        comanda.setEmail(comandaDto.getEmail());
        comanda.setNrtelefon(comandaDto.getNrtelefon());
        comanda.setCodpostal(comandaDto.getCodpostal());
        return comanda;

    }
}
