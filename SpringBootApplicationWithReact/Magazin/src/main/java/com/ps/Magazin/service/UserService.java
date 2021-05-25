package com.ps.Magazin.service;


import com.ps.Magazin.dto.*;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.ProdusComanda;
import com.ps.Magazin.model.User;
import org.springframework.stereotype.Component;

import javax.swing.event.ChangeEvent;
import java.util.List;

@Component
public interface UserService {
    List<User> findAll();
    User deleteUser(Long id);
    User updateUser(User dto);
    User findbyId(Long id);
    UserDto save(UserDto userDto) throws ApiExceptionResponse;
    void save(User dto);
    void delete(Long id);
    public List<User> listAll();
    String findUsername(String email);
    User findByUsername(String username);
    User findByEmail(String email);
    String extractLastRol1(String email);
    List<ProdusComanda> listaProduse(Long id);
    User deleteParfum(ProduseUserDto dto);
    User updateWishList(UserParfumAdditionDto dto);
    List<Parfum> listaWishList(Long id);
    User deleteParfumFromWishList(UserParfumAdditionDto dto);
    User logOut(Long id);
    User forgotPassword(EmailDto dto) throws ApiExceptionResponse;
    User resetPassword(ResetPasswordDto dto);
    User changePassword(ChangePasswordDto dto);
    User updateUser1(User dto);








}
