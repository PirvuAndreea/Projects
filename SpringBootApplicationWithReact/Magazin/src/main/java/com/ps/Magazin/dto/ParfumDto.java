package com.ps.Magazin.dto;

import com.ps.Magazin.model.Review;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParfumDto {
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
    private String filename;
   // private List<Review> reviewList;
}

