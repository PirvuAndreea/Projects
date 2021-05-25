package com.ps.Magazin.dto;

import com.ps.Magazin.model.ProdusComanda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComandaDto {


    private String prenume;
    private String nume;
    private String oras;
    private String adresa;
    private String email;
    private String nrtelefon;
    private Integer codpostal;

}
