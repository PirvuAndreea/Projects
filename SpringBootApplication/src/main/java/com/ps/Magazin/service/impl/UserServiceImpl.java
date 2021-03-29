package com.ps.Magazin.service.impl;


import com.ps.Magazin.model.User;
import com.ps.Magazin.repository.UserRepository;
import com.ps.Magazin.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
       this.userRepository = userRepository;
    }


    @Override
    public User findbyId(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public String findUsername(String email) {
        return userRepository.findUsername(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String extractLastRol1(String email) {
        return userRepository.extractLastRol1(email);
    }
}
