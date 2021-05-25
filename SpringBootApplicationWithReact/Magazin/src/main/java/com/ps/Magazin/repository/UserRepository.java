package com.ps.Magazin.repository;


import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByUsername(String username);
    List<User> findAllByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.email=?1")
    User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.username=?1")
    User findByUsername(String username);
    @Query("SELECT max(u.id) FROM User u")
    Long extractMaxID(List<User> users);
    @Query("SELECT u.rol FROM User u WHERE u.id=?1")
    String extractLastRol(Long id);
    @Query("SELECT u.rol FROM User u WHERE u.email=?1")
    String extractLastRol1(String email);
    @Query("SELECT u.rol FROM User u WHERE u.username=?1")
    String extractRol(String username);
    List <User> findAll();
    @Query("SELECT u.username FROM User u WHERE u.email=?1")
    String findUsername(String email);
    @Query("SELECT u.id FROM User u WHERE u.username=?1")
    Long extractID(String username);


}
