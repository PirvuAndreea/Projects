package com.ps.Magazin.utils;

import com.ps.Magazin.model.Review;

import javax.persistence.PostPersist;

public class ReviewEventListener {
    @PostPersist
    public void notifyCreation(Review review) {
        System.out.println("Un nou review '" + review.getMesaj() + "' de la " + review.getAutor());
    }
}
