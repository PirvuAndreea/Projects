package com.ps.Magazin.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder

@AllArgsConstructor
@Data
public class Parfum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeparfum;
    private String producator;
    private Integer anfabricatie;
    private String tara;
    private String genparfum;
    private String continut;
    private String descriere;
    private Float pret;
    private Integer cantitate;
    private String tip;

    @OneToMany(fetch = FetchType.EAGER)
    //@OneToMany(cascade = CascadeType.PERSIST)
    private List<Review> reviewList;

    public Parfum(){
        this.reviewList=new ArrayList<>();

    }

    public void addReview(Review review)
    {
        this.reviewList.add(review);
    }

}
