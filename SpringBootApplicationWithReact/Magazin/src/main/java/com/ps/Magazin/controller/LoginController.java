package com.ps.Magazin.controller;

import com.ps.Magazin.dto.CredentialsDTO;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.service.impl.LoginServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
    private final LoginServiceImpl loginService;

    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @ApiOperation(value = "Returns a login request")
    @PostMapping("/login")
    public ResponseEntity loginReq(@ApiParam(value = "Requires user credentials")@RequestBody CredentialsDTO dto) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(dto));
    }
}
