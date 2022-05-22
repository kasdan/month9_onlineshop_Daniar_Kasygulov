package com.attractor.month9onlineshop.controllers;


import com.attractor.month9onlineshop.constant.Constants;
import com.attractor.month9onlineshop.dto.LoginDTO;
import com.attractor.month9onlineshop.dto.UserDTO;
import com.attractor.month9onlineshop.dto.UserRegistrationDTO;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.exceptions.UserAlreadyExistsException;
import com.attractor.month9onlineshop.exceptions.UserEmailAlreadyExistsException;
import com.attractor.month9onlineshop.exceptions.UserNotFoundException;
import com.attractor.month9onlineshop.services.CapchaService;
import com.attractor.month9onlineshop.services.RestorePasswordService;
import com.attractor.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CapchaService capchaService;
    private final RestorePasswordService restorePasswordService;

    @GetMapping("/restore")
    public String restorePassword() {
        return "restore";
    }

    @PostMapping("/restore")
    public String restorePasswordPost(@RequestParam(name="email") String email, RedirectAttributes attributes) {
        String uniqueLink = restorePasswordService.restorePassword(email);
        attributes.addAttribute("uniqueLink",uniqueLink);
        return "redirect:/restore";
    }
    @GetMapping("/restore/{hash}")
    public String restorePasswordLink(@PathVariable String hash, Model model, HttpServletRequest request) {
        restorePasswordService.changePassword(hash,request);
        return "redirect:/";
    }


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
    System.out.println(principal.toString());
    return "profile";
    }
    @GetMapping("/register")
    public String getRegistration(Model model){

    model.addAttribute("capcha",capchaService.getNewCapcha());
    return "register";
    }

    @PostMapping(value = "/register")
    public String getRegistrationForm(@Valid UserRegistrationDTO userRegistrationDTO, @RequestParam(name="capcha") String capcha,
                                      BindingResult validationResult, Model model){
    System.out.println(capcha);
         if(!capchaService.checkCapcha(capcha) || capcha==null){
            model.addAttribute("errorCapcha","Please enter correct captcha");
            model.addAttribute("capcha",capchaService.getNewCapcha());
            return "register";
        }
        else if (validationResult.hasFieldErrors()) {
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
