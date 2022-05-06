package com.attractor.month9onlineshop.controllers;


import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/get_username")
    public User sendUserName(@RequestParam(name = "username") String username) {
        return userService.getUserByUserName(username);
    }
}
