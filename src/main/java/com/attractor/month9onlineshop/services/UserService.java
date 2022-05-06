package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private User user;

    public User getUserByUserName(String username){

        user = userRepository.findUserByUserName(username);
        return user;
    }
}
