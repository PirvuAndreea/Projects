package com.ps.Magazin.service.impl;

import com.ps.Magazin.constants.FileType;
import com.ps.Magazin.dto.ParfumCosDto;
import com.ps.Magazin.dto.ParfumCosDtoDelete;
import com.ps.Magazin.dto.ParfumDto;
import com.ps.Magazin.dto.ParfumReviewAdditionDTO;
import com.ps.Magazin.mapper.ParfumMapper;
import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.ProdusComanda;
import com.ps.Magazin.model.Review;
import com.ps.Magazin.repository.ParfumRepository;
import com.ps.Magazin.repository.ProdusComandaRepository;
import com.ps.Magazin.repository.ReviewRepository;
import com.ps.Magazin.service.ParfumService;
import com.ps.Magazin.utils.exporter.FileExporter;
import com.ps.Magazin.utils.exporter.TXTFileExporter;
import com.ps.Magazin.utils.exporter.XMLFileExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ParfumServiceImpl implements ParfumService {


    //@Autowired
    @Autowired
    private SimpMessagingTemplate template;

    //private ParfumRepository parfumRepository;
    private final ParfumRepository parfumRepository;
    private final ReviewRepository reviewRepository;
    private final ProdusComandaRepository produsComandaRepository;
    public ParfumServiceImpl(ParfumRepository parfumRepository, ReviewRepository reviewRepository, ProdusComandaRepository produsComandaRepository) {
        this.parfumRepository = parfumRepository;
        this.reviewRepository = reviewRepository;
        this.produsComandaRepository = produsComandaRepository;
    }

    @Override
    public Parfum findbyId(Long id) {
        return parfumRepository.findById(id).orElseThrow();
    }

    @Override
    public Parfum updateParfum(Parfum dto) {
        System.out.println(dto.getId());
        Parfum parfum=parfumRepository.findById(dto.getId()).get();
        //parfum.setId(dto.getId());
        parfum.setNumeparfum(dto.getNumeparfum());
        parfum.setProducator(dto.getProducator());
        parfum.setAnfabricatie(dto.getAnfabricatie());
        parfum.setTara(dto.getTara());
        parfum.setGenparfum(dto.getGenparfum());
        parfum.setContinut(dto.getContinut());
        parfum.setDescriere(dto.getDescriere());
        parfum.setPret(dto.getPret());
        parfum.setCantitate(dto.getCantitate());
        parfum.setTip(dto.getTip());
        parfum.setFilename(dto.getFilename());
        parfum.setIncos(dto.getIncos());
        parfum.setReviewList(dto.getReviewList());
        parfumRepository.save(parfum);
        return parfum;
    }


    @Override
    //nu mai trebuie save daca punem asa
   // @Transactional
    /*public Parfum updateParfum(Parfum dto) {
        *//*apelam de 2 ori find
        if (parfumRepository.findById(dto.getId()).isPresent()) {
            Parfum parfum = parfumRepository.findById(dto.getId()).get();
        }
        return null;*//*
        Parfum parfum = parfumRepository.findById(dto.getId()).orElseThrow();
        parfum.setPret(500.0f);
        parfum.setNumeparfum("nume nou");
       // parfumRepository.save(parfum);
       // List<Review> listaReview = new ArrayList<>();
       // listaReview.add(new Review(null, "Maria", "produs preferat", LocalDate.now()));
       // parfum.setReviewList(listaReview);
        //reviewRepository.saveAll(listaReview);
        return parfum;
    }*/


    public Parfum findbyNumeParfum(String numeparfum) {

        return parfumRepository.findFirstByNumeparfum(numeparfum);
    }
    public Parfum findbyProducator(String producator) {

        return parfumRepository.findFirstByProducator(producator);
    }

    @Override
    public List<Parfum> findAll() {
        List<Parfum> parfumuri=(List<Parfum>)parfumRepository.findAll();
        return parfumuri;
    }

    @Override
    public List<Parfum> filter(List<String> parfum, List<String> gen, List<Integer> pret) {
        return null;
    }

    @Override
    public List<Parfum> findByPerfumOrderByPriceDesc(String parfum) {
        return null;
    }

    @Override
    public List<Parfum> findByPerfumGenOrderByPretDesc(String genparfum) {
        return null;
    }

    @Override
    public Parfum savePerfum(Parfum parfum, MultipartFile file) {
        return null;
    }

    @Override
    public ParfumDto save(ParfumDto parfumDto) {
        //dto->model
        //repo.save(model)
        //mapare model -> dto
        //return dto
        Parfum parfum = ParfumMapper.mapDtoToModel(parfumDto);

        parfum.setIncos(false);
        parfum.setReviewList(null);
        parfum = parfumRepository.save(parfum);

        template.convertAndSend("/topic/socket/parfum", "Un nou parfum este disponibil\n" + "Nume: " +  parfum.getNumeparfum() + "\n" + "Producator: " + parfum.getProducator());

        return ParfumMapper.mapModelToDto(parfum);


    }

    @Override
    public Parfum updateReview(ParfumReviewAdditionDTO dto) {
        Parfum parfum = parfumRepository.findById(dto.getParfumID()).get();
        //Review review = reviewRepository.findById(dto.getReviewID()).get();
        Review review = new Review();
        System.out.println(dto.getMesajrev());
        review.setMesaj(dto.getMesajrev());
        review.setAutor(dto.getAutorrev());
        reviewRepository.save(review);
        parfum.getReviewList().add(review);
        return parfumRepository.save(parfum);
    }

    @Override
    public Parfum updateCos(ParfumCosDto dto) {
        Parfum parfum = parfumRepository.findById(dto.getId()).get();
        parfum.setIncos(dto.getIncos());
        return parfumRepository.save(parfum);
    }

    @Override
    public List<Parfum> updateCosFalse() {
        List<Parfum> parfumuri = (List<Parfum>) parfumRepository.findAll();
        for(Parfum parfum :parfumuri)
        {
            parfum.setIncos(false);

        }
        return (List<Parfum>) parfumRepository.saveAll(parfumuri);
    }

    @Override
    public List<Parfum> parfumTrueInCos() {
        List<Parfum> parfumuri=(List<Parfum>)parfumRepository.findAllByIncosTrue();
        return parfumuri;


    }

    @Override
    public Parfum updateCosDelete(ParfumCosDtoDelete dto) {
        Parfum parfum = parfumRepository.findById(dto.getId()).get();
        parfum.setIncos(false);
        return parfumRepository.save(parfum);
    }

    @Override
    public Parfum deleteParfum(Long id) {
        Parfum parfum = parfumRepository.findById(id).get();
        List<ProdusComanda> produse = produsComandaRepository.findParfumisProdusComanda(parfum);
        produsComandaRepository.deleteAll(produse);
        parfumRepository.delete(parfum);

        return parfum;
    }

    @Override
    public String exportParfumDetails(Long id, String fileType) {
        Parfum parfum=this.findbyId(id);
        FileExporter fileExporter;
        if(fileType.equals(FileType.XML)){
            fileExporter=new XMLFileExporter();
            return fileExporter.exportData(parfum);
        }
        else if(fileType.equals(FileType.TXT)){
            fileExporter=new TXTFileExporter();
            return fileExporter.exportData(parfum);
        }
        return null;
    }



    public List<Parfum> listAll(String keyword){
        if(keyword!=null) {
            return parfumRepository.findAll(keyword);
        }
        return (List<Parfum>) parfumRepository.findAll();
    }



    public void save(Parfum parfum) {
        parfumRepository.save(parfum);

    }

    public void delete(Long id){

        parfumRepository.deleteById(id);
    }

    @Override
    public boolean delete(Parfum parfum) {
       parfumRepository.deleteById(parfum.getId());
       if(parfumRepository.findFirstByNumeparfum(parfum.getNumeparfum())==null){
            return true;
        }
        return false;
    }
}
