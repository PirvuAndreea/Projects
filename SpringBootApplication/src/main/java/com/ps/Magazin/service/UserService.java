package com.ps.Magazin.service;


import com.ps.Magazin.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    User findbyId(Long id);
    void save(User dto);
    void delete(Long id);
    public List<User> listAll();
    String findUsername(String email);
    User findByUsername(String username);
    User findByEmail(String email);
    String extractLastRol1(String email);

}
