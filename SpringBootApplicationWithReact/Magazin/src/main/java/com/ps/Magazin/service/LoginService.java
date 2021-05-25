package com.ps.Magazin.service;

import com.ps.Magazin.dto.CredentialsDTO;
import com.ps.Magazin.dto.LoginSuccesDTO;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import org.springframework.stereotype.Component;

@Component
public interface LoginService {
    LoginSuccesDTO login(CredentialsDTO dto) throws ApiExceptionResponse;
}
