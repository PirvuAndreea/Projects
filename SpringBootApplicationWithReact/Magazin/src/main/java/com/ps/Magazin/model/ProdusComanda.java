package com.ps.Magazin.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdusComanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float valoare;
    @NotNull
    private Integer cantitate;



    @ManyToOne( fetch = FetchType.EAGER)
    private Parfum parfum;



}
