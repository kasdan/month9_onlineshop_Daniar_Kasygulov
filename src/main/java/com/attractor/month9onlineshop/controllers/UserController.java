package com.attractor.month9onlineshop.controllers;


import com.attractor.month9onlineshop.dto.LoginDTO;
import com.attractor.month9onlineshop.dto.UserDTO;
import com.attractor.month9onlineshop.dto.UserRegistrationDTO;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.Utf8Decoder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @PostMapping("/login")
    public String getUserName(@Valid LoginDTO loginDTO, BindingResult validationResult, Model model) {
        if (validationResult.hasFieldErrors()) {
            model.addAttribute("errors", validationResult.getFieldErrors());
            return "index";
      } else {
           model.addAttribute("user", userService.getUserByUserName(loginDTO.getUsername()));
            return "login";
        }
    }


    @GetMapping("/register")
    public String getRegistation(){
        return "register";
    }

    @PostMapping(value = "/registration")
    public String getRegistrationForm(@Valid UserRegistrationDTO userRegistrationDTO,BindingResult validationResult, Model model){
        if (validationResult.hasFieldErrors()) {
            model.addAttribute("errors",validationResult.getFieldErrors());
            return "register";
        }
        else {
            model.addAttribute("user", userService.addUser(userRegistrationDTO));
            return "registration";
        }

    }
}
