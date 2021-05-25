package com.ps.Magazin.dto;

import com.ps.Magazin.model.RolUser;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {


    private String username;
    private String password;
    private String email;

    //private String codactivare;
  //  private RolUser rol;
}
