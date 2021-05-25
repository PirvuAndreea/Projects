package com.ps.Magazin.mapper;


import com.ps.Magazin.dto.ParfumDto;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.model.Parfum;

import java.util.LinkedList;
import java.util.List;

public class ParfumMapper {

    public static ParfumDto mapModelToDto(Parfum parfum)
    {
        ParfumDto parfumDto = new ParfumDto();
        parfumDto.setId(parfum.getId());
        parfumDto.setNumeparfum(parfum.getNumeparfum());
        parfumDto.setProducator(parfum.getProducator());
        parfumDto.setAnfabricatie(parfum.getAnfabricatie());
        parfumDto.setTara(parfum.getTara());
        parfumDto.setGenparfum(parfum.getGenparfum());
        parfumDto.setContinut(parfum.getContinut());
        parfumDto.setDescriere(parfum.getDescriere());
        parfumDto.setPret(parfum.getPret());
        parfumDto.setCantitate(parfum.getCantitate());
        parfumDto.setTip(parfum.getTip());
        parfumDto.setFilename(parfum.getFilename());

        //parfumDto.setReviewList(parfum.getReviewList());
        return parfumDto;

    }

    public static Parfum mapDtoToModel(ParfumDto parfumDto)
    {
        Parfum parfum = new Parfum();
        parfum.setId(parfumDto.getId());
        parfum.setNumeparfum(parfumDto.getNumeparfum());
        parfum.setProducator(parfumDto.getProducator());
        parfum.setAnfabricatie(parfumDto.getAnfabricatie());
        parfum.setTara(parfumDto.getTara());
        parfum.setGenparfum(parfumDto.getGenparfum());
        parfum.setContinut(parfumDto.getContinut());
        parfum.setDescriere(parfumDto.getDescriere());
        parfum.setPret(parfumDto.getPret());
        parfum.setCantitate(parfumDto.getCantitate());
        parfum.setTip(parfumDto.getTip());
        parfum.setFilename(parfumDto.getFilename());
        //parfum.setReviewList(parfumDto.getReviewList());

        return parfum;

    }


    //pt detalii(cand nu e nevoie de toate atributele din parfum)
    /*public static List<ParfumDto> mapParfumToDetails(List<Parfum> parfumuri) throws ApiExceptionResponse {
        List<ParfumDto> dtos=new LinkedList<>();
        for(Parfum parfum:parfumuri){
            dtos.add(ParfumDto.builder().numeparfum(parfum.getNumeparfum()).producator(parfum.getProducator())
                    .anfabricatie(parfum.getAnfabricatie()).tara(parfum.getTara())
                    .genparfum(parfum.getGenparfum()).continut(parfum.getContinut())
                    .descriere(parfum.getDescriere()).pret(parfum.getPret()).cantitate(parfum.getCantitate())
                    .tip(parfum.getTip()).reviewList(parfum.getReviewList()).build());
        }
        return dtos;
    }*/

}
