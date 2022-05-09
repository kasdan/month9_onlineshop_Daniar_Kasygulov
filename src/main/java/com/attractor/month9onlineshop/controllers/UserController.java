package com.attractor.month9onlineshop.controllers;


import com.attractor.month9onlineshop.dto.LoginDTO;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
    public String sendUserName(@Valid @RequestParam String username,String password,
                                Model model) {
        System.out.println(username);
        System.out.println(password);
        model.addAttribute("user",userService.getUserByUserName(username));
        return "login";
    }
}
