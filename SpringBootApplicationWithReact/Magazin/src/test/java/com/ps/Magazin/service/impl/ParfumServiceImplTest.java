package com.ps.Magazin.service.impl;

import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.Review;
import com.ps.Magazin.repository.ParfumRepository;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class ParfumServiceImplTest {

    //constante
//    private static final String NUMEPARFUM ="test";
//
//    //la nivel de implementare
//    private ParfumServiceImpl parfumService;
//
//    @Mock
//    private ParfumRepository parfumRepository;
//
//
//
//
//    private Parfum parfum;
//
//    @BeforeEach
//    void setup(){
//        initMocks(this);
//        parfum = new Parfum();
//        parfum.setNumeparfum(NUMEPARFUM);
//        parfum.setId(2l);
//
//    }
//
//
//
//    @Test
//    void givenParfum_whenSaveParfum_thenSaved() {
//
//        //given
//        Parfum parfum1 = new Parfum(null, "Parfum1","Producator1", 2000, "Romania" , "Femeie", "continut", "descriere",100.0f, 100, "apa de parfum",null,  null );
//
//        //when
//        when(parfumRepository.save(any(Parfum.class))).thenReturn(parfum1);
//        Parfum savedParfum = parfumRepository.save(parfum1);
//
//        //then
//        assertNotNull(savedParfum);
//    }
//
//
//
//
//    @Test
//    void NonCreatedParfum_whenSaveParfum_thenThrow() {
//
//        //given
//        Parfum parfum1 = new Parfum(null, "Parfum1","Producator1", 2000, "Romania" , "Femeie", "continut", "descriere",100.0f, 100, "apa de parfum", null,null );
//
//        //when
//        when(parfumRepository.save(parfum1)).thenReturn(null);
//
//        //then
//        Exception exception = assertThrows(NullPointerException.class, ()->
//                parfumService.save(parfum1));
//    }
//
//    @Test
//    void givenExistingNumeParfum_whenfindbyNumeParfum_thenFindOne() {
//        //given
//        parfumService = new ParfumServiceImpl(parfumRepository);
//
//        //when
//        Parfum parfum2 = parfumService.findbyNumeParfum(NUMEPARFUM);
//
//        //then
//        assertNotNull(parfum2);
//        assertEquals("test", parfum2.getNumeparfum());
//    }
//
//    @Test
//    void givenNonExistingNumeParfum_whenfindbyNumeParfum_thenThrow(){
//        when(parfumRepository.findFirstByNumeparfum("nu exista")).thenReturn(null);
//
//        Exception exception = assertThrows(NullPointerException.class, ()->
//                parfumService.findbyNumeParfum("nu exista"));
//    }
//
//
//
//    @Test
//    void givenParfum_whenDeleteParfum_thenThrowTrue(){
//        //given
//        Parfum parfum1=new Parfum();
//        parfum1.setId(18L);
//        parfumRepository.save(parfum1);
//
//        parfumService=new ParfumServiceImpl(parfumRepository);
//        //when
//        boolean test=parfumService.delete(parfum1);
//
//        //then
//        assertEquals(true,test);
//
//    }
//
//
//    @Test
//    void givenParfum_whenDeleteParfum_thenThrow(){
//        //given
//        Parfum parfum1=new Parfum();
//        parfum1.setId(8L);
//        parfumRepository.save(parfum1);
//        //when
//        parfumRepository.delete(parfum1);
//        when(parfumRepository.findById(new Long(8))).thenReturn(Optional.of(parfum1));
//
//        //then
//        Exception exception = assertThrows(NullPointerException.class, ()->
//                parfumService.delete(parfum1));
//
//    }

}