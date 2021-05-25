package com.ps.Magazin.service.impl;


import com.ps.Magazin.dto.*;
import com.ps.Magazin.exceptions.ApiExceptionResponse;
import com.ps.Magazin.mapper.UserMapper;
import com.ps.Magazin.model.*;
import com.ps.Magazin.repository.ParfumRepository;
import com.ps.Magazin.repository.ProdusComandaRepository;
import com.ps.Magazin.repository.UserRepository;
import com.ps.Magazin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SimpMessagingTemplate template;

    private final UserRepository userRepository;
    private final ProdusComandaRepository produsComandaRepository;
    private final ParfumRepository parfumRepository;
    private final JavaMailSender javaMailSender;

    public UserServiceImpl(UserRepository userRepository, ProdusComandaRepository produsComandaRepository, ParfumRepository parfumRepository, JavaMailSender javaMailSender) {
       this.userRepository = userRepository;
        this.produsComandaRepository = produsComandaRepository;
        this.parfumRepository = parfumRepository;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public User findbyId(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public UserDto save(UserDto userDto) throws ApiExceptionResponse {
        //dto->model
        //repo.save(model)
        //mapare model -> dto
        //return dto
        if(userRepository.findByUsername(userDto.getUsername()) == null && userRepository.findByEmail(userDto.getEmail())==null) {
            User user = UserMapper.mapDtoToModel(userDto);
            user.setCodactivare(32566);
            user.setRol(RolUser.ADMIN);
            user.setEnable(true);
            user.setForgotPassword(false);
            user = userRepository.save(user);
            return UserMapper.mapModelToDto(user);
        }
        else
        {
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials")).build();
        }
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

    @Override
    public List<ProdusComanda> listaProduse(Long id) {
        User user = userRepository.findById(id).get();
        if(user.getProduse() == null)
        {
            return null;
        }
        else {
            return user.getProduse();
        }
    }

    @Override
    public User deleteParfum(ProduseUserDto dto) {
        User user = userRepository.findById(dto.getIdUser()).get();
        ProdusComanda produsComanda = produsComandaRepository.findById(dto.getIdProdusComanda()).get();
       // produsComanda.getParfum().setCantitate(produsComanda.getParfum().getCantitate()+produsComanda.getCantitate());
        user.getProduse().remove(produsComanda);
        //produsComandaRepository.delete(produsComanda);


        return userRepository.save(user);
    }

    @Override
    public User updateWishList(UserParfumAdditionDto dto) {
        User user = userRepository.findById(dto.getIdUser()).get();
        Parfum parfum = parfumRepository.findById(dto.getIdParfum()).get();
        user.getWishList().add(parfum);
        userRepository.save(user);
        System.out.println(user);
        return user;
    }

    @Override
    public List<Parfum> listaWishList(Long id) {
        User user = userRepository.findById(id).get();
        return user.getWishList();
    }

    @Override
    public User deleteParfumFromWishList(UserParfumAdditionDto dto) {
        User user = userRepository.findById(dto.getIdUser()).get();
        Parfum parfum = parfumRepository.findById(dto.getIdParfum()).get();
        user.getWishList().remove(parfum);
        userRepository.save(user);
        System.out.println("Dupa stergere:");
        System.out.println(user);
        return user;
    }

    @Override
    public User logOut(Long id) {
        User user= userRepository.findById(id).get();
        user.setActiv(false);
        userRepository.save(user);
        template.convertAndSend("/topic/socket/user", "Userul cu " + "username-ul: " +  user.getUsername() + " a iesit");
        System.out.println(user);
        return user;
    }

    @Override
    public User forgotPassword(EmailDto dto) throws ApiExceptionResponse {

        if (userRepository.findByEmail(dto.getEmail()) != null) {
            User user = userRepository.findByEmail(dto.getEmail());
            user.setForgotPassword(true);
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(dto.getEmail());
            String mesajDeTrimis = "Accesati urmatorul link pentru resetarea parolei: \n" + "http://localhost:3000/resetPassword";
            msg.setSubject("Validare e-mail");
            msg.setText(mesajDeTrimis);
            javaMailSender.send(msg);
            userRepository.save(user);
            System.out.println(user);
            return user;
        } else {
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials")).build();
        }
    }

    @Override
    public User resetPassword(ResetPasswordDto dto) {
        User user = userRepository.findByEmail(dto.getEmail());

        if(dto.getPassword().equals(dto.getConfirmPassword()))
        {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(dto.getPassword());
            System.out.println(encoder.matches(dto.getPassword(), encodedPassword));
            user.setPassword(encodedPassword);

            user.setForgotPassword(false);
            userRepository.save(user);
            return user;

        }
        else {
            return null;
        }
    }

    @Override
    public User changePassword(ChangePasswordDto dto) {
        User user = userRepository.findById(dto.getUserID()).get();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(dto.getNewPassword());
        System.out.println(dto.getConfirmPassword());
        System.out.println(encoder.matches(dto.getOldPassword(), user.getPassword()));
        if (encoder.matches(dto.getOldPassword(), user.getPassword()) == true) {
            if (dto.getNewPassword().equals(dto.getConfirmPassword()))
            {

                String encodedPassword = encoder.encode(dto.getNewPassword());

                user.setPassword(encodedPassword);
                userRepository.save(user);
                return user;
            } else {
                return null;
            }

        } else {
            return null;
        }

    }


    @Override
    public List<User> findAll() {
        List<User> users=(List<User>)userRepository.findAll();
        return users;
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }

    @Override
    public User updateUser(User dto) {
        User user=userRepository.findById(dto.getId()).get();
        //parfum.setId(dto.getId());
        user.setUsername(dto.getUsername());


        // System.out.println(encoder.matches(dto.getPassword(), encodedPassword));
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setCodactivare(dto.getCodactivare());
        user.setRol(dto.getRol());
        user.setEnable(dto.getEnable());
        userRepository.save(user);
        return user;
    }

    public User updateUser1(User dto) {
        User user=userRepository.findById(dto.getId()).get();
        //parfum.setId(dto.getId());
        user.setUsername(dto.getUsername());
        // System.out.println(encoder.matches(dto.getPassword(), encodedPassword));
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setCodactivare(dto.getCodactivare());
        user.setRol(dto.getRol());
        user.setEnable(dto.getEnable());
        userRepository.save(user);
        return user;
    }


}
