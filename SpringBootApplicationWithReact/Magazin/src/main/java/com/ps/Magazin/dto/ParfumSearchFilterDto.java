package com.ps.Magazin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ParfumSearchFilterDto {
    private List<Float> pret;
    private List<String> perfumuri;
    private List<String> genuri;
    private String genparfum;
    private String parfum;
}
