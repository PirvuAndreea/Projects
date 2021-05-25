package com.ps.Magazin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParfumReviewAdditionDTO {
   // private Long reviewID;
    //trebuie sa se numeasca la fel ca in js
    private Long parfumID;
    private String autorrev;
    private String mesajrev;
}
