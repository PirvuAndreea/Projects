package com.ps.Magazin.service;


import com.ps.Magazin.dto.ParfumReviewAdditionDTO;

import com.ps.Magazin.dto.UserDto;
import com.ps.Magazin.dto.ValidationDto;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.model.User;
import org.springframework.stereotype.Component;

@Component
public interface RegisterService {
    User saveUser(UserDto dto)throws ApiExceptionResponse;
    User saveUserAfterActivate(ValidationDto dto);
}
