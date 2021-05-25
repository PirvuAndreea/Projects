package com.ps.Magazin.service.impl;


import com.ps.Magazin.dto.CredentialsDTO;
import com.ps.Magazin.dto.LoginSuccesDTO;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.model.User;
import com.ps.Magazin.repository.UserRepository;
import com.ps.Magazin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SimpMessagingTemplate template;

    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginSuccesDTO login(CredentialsDTO dto) throws ApiExceptionResponse {
        User user=userRepository.findByUsername(dto.getUsername());

        System.out.println(user);
        if(user==null) {
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials"))
                    .message("User not found").status(HttpStatus.NOT_FOUND).build();
        }
        LoginSuccesDTO response= new LoginSuccesDTO();
      //  String role=user.getClass().getSimpleName().toUpperCase();
        String role = userRepository.extractRol(dto.getUsername());
        Long id = userRepository.extractID(dto.getUsername());
       // if(role.equals("USER")){
            //response=LoginSuccesDTO.builder().id(user.getId()).role(role).build();
            response.setId(id);
            response.setRole(role);
            response.setEnable(user.getEnable());




        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.matches(dto.getPassword(), user.getPassword()));


        //daca da true inseamna ca parola introdusa de utilizator este cea parola decrpitata corecta
        if(encoder.matches(dto.getPassword(), user.getPassword()) == true){
            user.setActiv(true);
            userRepository.save(user);
            template.convertAndSend("/topic/socket/user", "Un nou user este activ\n" + "Username: " +  user.getUsername() );

            return response;

        }

        throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials"))
                .message("User not found").status(HttpStatus.NOT_FOUND).build();
    }

}
