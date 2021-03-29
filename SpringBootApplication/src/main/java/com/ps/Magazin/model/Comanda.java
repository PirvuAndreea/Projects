package com.ps.Magazin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float prettotal;
    private LocalDate data;
    private String prenume;
    private String nume;
    private String oras;
    private String adresa;
    private String email;
    private String nrtelefon;
    private Integer codpostal;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ProdusComanda> produse;

    public Comanda(){
        this.data=LocalDate.now();
        this.produse = new ArrayList<>();
    }
}
