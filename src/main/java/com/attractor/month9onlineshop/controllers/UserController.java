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
//@GetMapping("index")
//public String indexReturn(){
//
//}
    //    @GetMapping("/index")
//    public String pageRegisterCustomer(Model model) {
//        if (!model.containsAttribute("form")) {
//            model.addAttribute("form", new LoginDTO());
//        }
//        return "index";
//    }
    @PostMapping("/login")
    public String getUserName(@Valid LoginDTO loginDTO, BindingResult validationResult, Model model) {
        // добавим в модель-представление нашу форму с данными

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
    public String getRegistrationForm(@Valid UserRegistrationDTO userRegistrationDTO, Model model){
        System.out.println(userRegistrationDTO.getUsername());
        System.out.println(userRegistrationDTO.getEmail());
        model.addAttribute("user",userService.addUser(userRegistrationDTO));
        return "registration";

    }
}
