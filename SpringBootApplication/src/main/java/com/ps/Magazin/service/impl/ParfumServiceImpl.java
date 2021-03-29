package com.ps.Magazin.service.impl;

import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.Review;
import com.ps.Magazin.repository.ParfumRepository;
import com.ps.Magazin.repository.ReviewRepository;
import com.ps.Magazin.service.ParfumService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

@Service
public class ParfumServiceImpl implements ParfumService {


    //@Autowired
    //private ParfumRepository parfumRepository;
    private final ParfumRepository parfumRepository;
  //  private final ReviewRepository reviewRepository;
    public ParfumServiceImpl(ParfumRepository parfumRepository) {
        this.parfumRepository = parfumRepository;
     //   this.reviewRepository = reviewRepository;
    }

    @Override
    public Parfum findbyId(Long id) {
        return parfumRepository.findById(id).get();
    }


    @Override
    //nu mai trebuie save daca punem asa
    @Transactional
    public Parfum updateParfum(Parfum dto) {
        /*apelam de 2 ori find
        if (parfumRepository.findById(dto.getId()).isPresent()) {
            Parfum parfum = parfumRepository.findById(dto.getId()).get();
        }
        return null;*/
        Parfum parfum = parfumRepository.findById(dto.getId()).orElseThrow();
        parfum.setPret(500.0f);
        parfum.setNumeparfum("nume nou");
       // parfumRepository.save(parfum);
       // List<Review> listaReview = new ArrayList<>();
       // listaReview.add(new Review(null, "Maria", "produs preferat", LocalDate.now()));
       // parfum.setReviewList(listaReview);
        //reviewRepository.saveAll(listaReview);
        return parfum;
    }

    public Parfum findbyNumeParfum(String numeparfum) {

        return parfumRepository.findFirstByNumeparfum(numeparfum);
    }
    public Parfum findbyProducator(String producator) {

        return parfumRepository.findFirstByProducator(producator);
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
