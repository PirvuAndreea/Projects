package com.ps.Magazin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "prenume cannot be empty")
    private String prenume;
    @NotBlank(message = "nume cannot be empty")
    private String nume;
    @NotBlank(message = "oras cannot be empty")
    private String oras;
    @NotBlank(message = "adresa cannot be empty")
    private String adresa;
    @Email
    private String email;
    @Size(min=10)
    private String nrtelefon;
    @Min(5)
    private Integer codpostal;



    public Comanda(){
        this.data=LocalDate.now();

    }
}
