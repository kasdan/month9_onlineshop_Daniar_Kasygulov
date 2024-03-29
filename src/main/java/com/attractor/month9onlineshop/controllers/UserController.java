package com.attractor.month9onlineshop.controllers;


import com.attractor.month9onlineshop.dto.UserRegistrationDTO;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.exceptions.CaptchaDoesNotMatchExeption;
import com.attractor.month9onlineshop.exceptions.UserAlreadyExistsException;
import com.attractor.month9onlineshop.exceptions.UserEmailAlreadyExistsException;
import com.attractor.month9onlineshop.services.CapchaService;
import com.attractor.month9onlineshop.services.RestorePasswordService;
import com.attractor.month9onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String restorePasswordPost(@RequestParam(name = "email") String email, Model model) {
        String uniqueLink = restorePasswordService.restorePassword(email);
        model.addAttribute("uniqueLink", uniqueLink);
        return "restore";
    }

    @GetMapping("/restore/{hash}")
    public String restorePasswordLink(@PathVariable String hash, Model model, HttpServletRequest request) {
        restorePasswordService.changePassword(hash, request);
        return "redirect:/";
    }


    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/logout")
    String logoutPage(Principal principal, Model model) {
        Optional<Principal> principalOptional = Optional.ofNullable(principal);
        if (principalOptional.isPresent()) {
            model.addAttribute("user", principal.getName());
        }
        return "logout";
    }

    @GetMapping("/profile")
    public String getProfile(Model model, Principal principal) {
        var user =
                model.addAttribute("user", userService.getUserByUserNameDTO(principal.getName()));
        return "profile";
    }

    @GetMapping("/register")
    public String getRegistration(Model model) {

        model.addAttribute("captcha", capchaService.getNewCapcha());
        return "register";
    }

    @PostMapping(value = "/register")
    public String getRegistrationForm(@Valid UserRegistrationDTO userRegistrationDTO,
                                      BindingResult validationResult, Model model) {
        if (validationResult.hasFieldErrors()) {
            model.addAttribute("captcha", capchaService.getNewCapcha());
            model.addAttribute("errorPassword", validationResult.getFieldError("password"));
            model.addAttribute("errorUsername", validationResult.getFieldError("username"));
            model.addAttribute("errorFullName", validationResult.getFieldError("fullName"));
            model.addAttribute("errorEmail", validationResult.getFieldError("email"));
            model.addAttribute("errorCaptcha", validationResult.getFieldError("captcha"));
            return "register";
        } else {
            Optional<User> optionalUser = Optional.ofNullable(userService.getUserByUserName(userRegistrationDTO.getUsername()));
            Optional<User> optionalUserByEmail = userService.findUserByEmail(userRegistrationDTO.getEmail());
            if (optionalUser.isPresent()) {
                throw new UserAlreadyExistsException();
            } else if (optionalUserByEmail.isPresent()) {
                throw new UserEmailAlreadyExistsException();
            } else if (!capchaService.checkCapcha(userRegistrationDTO.getCaptcha())) {
                throw new CaptchaDoesNotMatchExeption();
            }
            model.addAttribute("user", userService.addUser(userRegistrationDTO));
            return "login";
        }

    }

}
