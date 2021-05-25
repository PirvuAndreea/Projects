package com.ps.Magazin.controller;

import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logOut")
@CrossOrigin
public class LogOutController {
    private final UserService userService;

    public LogOutController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{id}")
    public ResponseEntity logOut(@ApiParam(value = "Requires an user id")@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.logOut(id));
    }
}
