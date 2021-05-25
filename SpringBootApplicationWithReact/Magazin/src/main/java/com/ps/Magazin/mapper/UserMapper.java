package com.ps.Magazin.mapper;

import com.ps.Magazin.dto.UserDto;
import com.ps.Magazin.model.User;
import com.ps.Magazin.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserDto mapModelToDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;

    }

    public static User mapDtoToModel(UserDto userDto)
    {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userDto.getPassword());
        user.setPassword(encodedPassword);


        return user;

    }
}
