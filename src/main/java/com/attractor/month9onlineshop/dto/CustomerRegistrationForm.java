package com.attractor.month9onlineshop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerRegistrationForm {

    @NotBlank
    @NotNull
    private String username;

    @NotNull
    @NotBlank
    @Email
    private String email;
}
