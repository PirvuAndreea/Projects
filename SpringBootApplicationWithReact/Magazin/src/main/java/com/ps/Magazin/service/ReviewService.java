package com.ps.Magazin.service;

import com.ps.Magazin.model.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReviewService {
    void save(Review review);
    Review findFirstByAutor(String autor);
    Review findById(Long id);
    void delete(Long id);
    Review findByMesaj(String mesaj);

}
