package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.repository.UserRepository;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
}
