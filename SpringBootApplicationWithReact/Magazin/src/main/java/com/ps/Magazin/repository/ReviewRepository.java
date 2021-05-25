package com.ps.Magazin.repository;

import com.ps.Magazin.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findByAutor(String autor);
    Optional<Review> findById(Long id);
    Review findByMesaj(String mesaj);

    Review findFirstByAutor(String autor);
}
