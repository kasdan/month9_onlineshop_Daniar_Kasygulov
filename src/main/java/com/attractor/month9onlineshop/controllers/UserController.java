package com.attractor.month9onlineshop.controllers;


import com.attractor.month9onlineshop.dto.LoginDTO;
import com.attractor.month9onlineshop.dto.UserDTO;
import com.attractor.month9onlineshop.dto.UserRegistrationDTO;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.exceptions.UserAlreadyExistsException;
import com.attractor.month9onlineshop.exceptions.UserEmailAlreadyExistsException;
import com.attractor.month9onlineshop.exceptions.UserNotFoundException;
import com.attractor.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
@GetMapping("/login")
public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
    model.addAttribute("error", error);
    return "login";
}
@GetMapping("/logout") String logoutPage(){
    return "logout";
}

    @GetMapping("/profile")
    public String getProfile(Model model, Principal principal){
    var user =
    model.addAttribute("user",userService.getUserByUserNameDTO(principal.getName()));
    return "profile";
    }
    @GetMapping("/register")
    public String getRegistration(){
        return "register";
    }

    @PostMapping(value = "/register")
    public String getRegistrationForm(@Valid UserRegistrationDTO userRegistrationDTO,BindingResult validationResult, Model model){
        if (validationResult.hasFieldErrors()) {
//            model.addAttribute("errors",validationResult.getFieldErrors());
            model.addAttribute("errorPassword",validationResult.getFieldError("password"));
            model.addAttribute("errorUsername",validationResult.getFieldError("username"));
            model.addAttribute("errorFullName",validationResult.getFieldError("fullName"));
            model.addAttribute("errorEmail",validationResult.getFieldError("email"));
            return "register";
        }
        else {
            Optional<User> optionalUser = Optional.ofNullable(userService.getUserByUserName(userRegistrationDTO.getUsername()));
            Optional<User> optionalUserByEmail = userService.findUserByEmail(userRegistrationDTO.getEmail());
            if(optionalUser.isPresent()){
                throw new UserAlreadyExistsException();
            }
            else if (optionalUserByEmail.isPresent()){
                throw new UserEmailAlreadyExistsException();
            }
            model.addAttribute("user", userService.addUser(userRegistrationDTO));
            return "login";
        }

    }
}
