package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.dto.UserDTO;
import com.attractor.month9onlineshop.dto.UserRegistrationDTO;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.repository.UserRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @NotBlank
    @NotNull
    private User user;

    public User getUserByUserName(String username){
        user = userRepository.findUserByUserName(username);
        return user;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public UserDTO addUser(UserRegistrationDTO userRegistrationDTO) {
        var username = userRegistrationDTO.getUsername();
        var users = getAllUsers().stream().filter(e->e.getUserName().equalsIgnoreCase(username)).findFirst();
        if(users.isPresent()){
            return null;
        }
        var user = User.builder()
                .userName(username)
                .email(userRegistrationDTO.getEmail())
                .fullName(userRegistrationDTO.getFullName())
                .password(userRegistrationDTO.getPassword())
                .build();
        userRepository.save(user);
        UserDTO  userDTO = UserDTO.builder()
                .username(user.getUserName())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .build();
        return userDTO;
    }
}
