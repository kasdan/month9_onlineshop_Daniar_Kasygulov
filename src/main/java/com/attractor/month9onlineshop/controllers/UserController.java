package com.attractor.month9onlineshop.controllers;


import com.attractor.month9onlineshop.dto.UserRegistrationDTO;
import com.attractor.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String indexPage(){
        return "index";
    }

    @GetMapping("/login")
    public String getUserName(@Valid @RequestParam String username,String password,
                                Model model) {
        model.addAttribute("user",userService.getUserByUserName(username));
        return "login";
    }

    @GetMapping("/register")
    public String getRegistation(){
        return "register";
    }

    @PostMapping("/registration")
    public String getRegistrationForm(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO, Model model){
        model.addAttribute("user",userService.addUser(userRegistrationDTO));

    }
}
