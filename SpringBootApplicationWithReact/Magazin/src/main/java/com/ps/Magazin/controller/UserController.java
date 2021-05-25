package com.ps.Magazin.controller;


import com.ps.Magazin.dto.*;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.User;
import com.ps.Magazin.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Returns a list of all users.")
    @GetMapping()
    public ResponseEntity findAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }


    @ApiOperation(value = "Delete user by id from list.")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@ApiParam(value = "Requires an user id")@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }

    @ApiOperation(value = "Return user by id from list.")
    @GetMapping("/{id}")
    public ResponseEntity findUserById(@ApiParam(value = "Requires an user id")@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findbyId(id));
    }

    @ApiOperation(value = "Update user from list.")
    @PutMapping("/update")
    public ResponseEntity updateUser(@ApiParam(value = "Requires an existant user")@RequestBody User dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(dto));
    }

    @PutMapping("/update1")
    public ResponseEntity updateUser1(@ApiParam(value = "Requires an existant user")@RequestBody User dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser1(dto));
    }
    @ApiOperation(value = "Add new user in list.")
    @PostMapping("/save")
    public ResponseEntity saveNewUser(@ApiParam(value = "Requires a new user")@RequestBody UserDto dto) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(dto));
    }
    @GetMapping("/produseCos{id}")
    public ResponseEntity findProduseCos(@ApiParam(value = "Requires an autor")@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listaProduse(id));
    }
    @PutMapping("/stergeProdusCos")
    public ResponseEntity updateProduseUser(@ApiParam(value = "Requires a parfum id, author review and message review")@RequestBody ProduseUserDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteParfum(dto));
    }

    @PutMapping("/addWishList")
    public ResponseEntity updateWishList(@ApiParam(value = "Requires an user id and parfum id")@RequestBody UserParfumAdditionDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateWishList(dto));
    }
    @GetMapping("/parfumuriWishList{id}")
    public ResponseEntity findParfumuriWishList(@ApiParam(value = "Requires an autor")@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listaWishList(id));
    }

    @PutMapping("/stergeParfumWishList")
    public ResponseEntity DeleteParfumWishList(@ApiParam(value = "Requires a parfum id and user id")@RequestBody UserParfumAdditionDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteParfumFromWishList(dto));
    }
    @PutMapping("/forgotPassword")
    public ResponseEntity forgotPassword(@ApiParam(value = "Requires a parfum id and user id")@RequestBody EmailDto dto) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(userService.forgotPassword(dto));
    }
    @PutMapping("/resetPassword")
    public ResponseEntity resetPassword(@ApiParam(value = "Requires a parfum id and user id")@RequestBody ResetPasswordDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.resetPassword(dto));
    }

    @PutMapping("/changePassword")
    public ResponseEntity changePassword(@ApiParam(value = "Requires a parfum id and user id")@RequestBody ChangePasswordDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.changePassword(dto));
    }

}
