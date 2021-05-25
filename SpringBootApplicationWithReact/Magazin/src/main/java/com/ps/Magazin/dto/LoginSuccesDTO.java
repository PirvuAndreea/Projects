package com.ps.Magazin.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
public class LoginSuccesDTO {

    private String role;
    private Long id;
    private Boolean enable;


}