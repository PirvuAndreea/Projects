package com.ps.Magazin.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@Data
@XmlRootElement(name="parfum")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString

public class Parfum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;
    @NotBlank(message = "numeparfum cannot be empty")
    @XmlElement(name="Nume parfum")
    private String numeparfum;
    @NotBlank(message = "producator cannot be empty")
    @XmlElement(name="Producator")
    private String producator;
    @Max(2020)
    @XmlTransient
    private Integer anfabricatie;
    @NotBlank(message = "tara cannot be empty")
    @XmlTransient
    private String tara;
    @NotBlank(message = "genparfum cannot be empty")
    @XmlTransient
    private String genparfum;
    @NotBlank(message = "continut cannot be empty")
    @XmlTransient
    private String continut;
    @NotBlank(message = "descriere cannot be empty")
    @XmlTransient
    private String descriere;
    @NotNull
    @XmlElement(name="Pret")
    private Float pret;
    @Min(1)
    @XmlElement(name="Stoc")
    private Integer cantitate;
    @NotBlank(message = "tip cannot be empty")
    @XmlTransient
    private String tip;
    @NotBlank(message = "filename cannot be empty")
    @XmlTransient
    private String filename;
    @XmlTransient
    private Boolean incos;
    @XmlTransient
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
