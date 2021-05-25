package com.ps.Magazin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdusComandaDto {
    private Long idParfum;
    private Long idUser;
    private Integer cantitate;

}
