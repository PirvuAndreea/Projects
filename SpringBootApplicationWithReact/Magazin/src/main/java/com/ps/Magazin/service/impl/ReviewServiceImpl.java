package com.ps.Magazin.service.impl;

import com.ps.Magazin.model.Review;
import com.ps.Magazin.repository.ReviewRepository;
import com.ps.Magazin.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review findFirstByAutor(String autor) {
        return (Review) reviewRepository.findFirstByAutor(autor);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).get();
    }



    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review findByMesaj(String mesaj) {
        return reviewRepository.findByMesaj(mesaj);
    }


}
