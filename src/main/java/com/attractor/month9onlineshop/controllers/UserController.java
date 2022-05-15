package com.attractor.month9onlineshop.controllers;


import com.attractor.month9onlineshop.dto.LoginDTO;
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
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/loginPage")
    public String indexPage() {
        return "login";
    }

    @PostMapping("/login")
    public String getUserName(@Valid LoginDTO loginDTO, BindingResult validationResult, Model model) {

        if (validationResult.hasFieldErrors()) {
            //model.addAttribute("errors", validationResult.getFieldErrors());
            model.addAttribute("errorUsername",validationResult.getFieldError("username"));
            model.addAttribute("errorPassword",validationResult.getFieldError("password"));
            model.addAttribute("form",loginDTO);
            //System.out.println(validationResult.getFieldErrors("username"));
            return "login";
      } else {
            Optional<User> userOptional = Optional.ofNullable(userService.getUserByUserName(loginDTO.getUsername()));
            if(userOptional.isPresent()) {

                model.addAttribute("user", userOptional.get());
                return "profile";
            }else {
                throw new UserNotFoundException();
            }

        }
    }

    @GetMapping("/register")
    public String getRegistration(){
        return "register";
    }

    @PostMapping(value = "/registration")
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
            return "registration";
        }

    }
}
