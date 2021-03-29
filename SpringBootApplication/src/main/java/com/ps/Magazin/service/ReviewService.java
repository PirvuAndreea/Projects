package com.ps.Magazin.service;

import com.ps.Magazin.model.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReviewService {
    void save(Review review);
    List<Review> findByAutor(String autor);
    Review findById(Long id);
    void delete(Long id);

}
