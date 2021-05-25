package com.ps.Magazin.service.impl;

import com.ps.Magazin.dto.UserDto;
import com.ps.Magazin.dto.ValidationDto;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.model.RolUser;
import com.ps.Magazin.model.User;
import com.ps.Magazin.repository.UserRepository;
import com.ps.Magazin.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;



    public RegisterServiceImpl(UserRepository userRepository, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public User saveUser(UserDto dto) throws ApiExceptionResponse {
        User user = new User();
        if (userRepository.findUsername(dto.getUsername()) == null && userRepository.findByEmail(dto.getEmail() ) == null) {
            user.setUsername(dto.getUsername());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(dto.getPassword());

            user.setPassword(encodedPassword);

            user.setEmail(dto.getEmail());
            user.setRol(RolUser.USER);
            user.setForgotPassword(false);
            int random_int = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(dto.getEmail());
            String codDeTrimis = "Codul de autentificare este:" + random_int + ".";
            msg.setSubject("Validare e-mail");
            msg.setText(codDeTrimis);
            System.out.println(random_int);
            javaMailSender.send(msg);
            user.setCodactivare(random_int);
            user.setEnable(false);

            userRepository.save(user);
            return user;
        } else {
           throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials")).build();

        }
    }


    @Override
    public User saveUserAfterActivate(ValidationDto dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        System.out.println(user);
        System.out.println(user.getCodactivare());
        System.out.println(dto.getCod_activare());
        if(user.getCodactivare().equals(dto.getCod_activare()))
       {
            user.setEnable(true);
            System.out.println(user.getEnable());
            return userRepository.save(user);
        }
        else
            return null;
    }
}
