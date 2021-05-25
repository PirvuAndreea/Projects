package com.ps.Magazin.dto;

import lombok.Data;

@Data
public class ChangePasswordDto {
    private Long userID;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
