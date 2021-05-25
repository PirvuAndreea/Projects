package com.ps.Magazin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserParfumAdditionDto {
    private Long idUser;
    private Long idParfum;
}
