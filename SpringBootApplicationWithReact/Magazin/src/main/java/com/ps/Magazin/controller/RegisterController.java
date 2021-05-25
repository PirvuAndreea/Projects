package com.ps.Magazin.controller;

import com.ps.Magazin.dto.CredentialsDTO;
import com.ps.Magazin.dto.UserDto;
import com.ps.Magazin.dto.ValidationDto;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.service.impl.RegisterServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RegisterController {
    private final RegisterServiceImpl registerService;

    public RegisterController(RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }

    @ApiOperation(value = "Save new user.")
    @PostMapping("/signup")
    public ResponseEntity loginReq(@ApiParam(value = "Requires a new user")@RequestBody UserDto dto) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(registerService.saveUser(dto));
    }
    @ApiOperation(value = "Save  user before activate.")
    @PutMapping("/validateSignUp")
    public ResponseEntity ValidateRegister(@ApiParam(value = "Requires an email and activation code")@RequestBody ValidationDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(registerService.saveUserAfterActivate(dto));
    }
}
