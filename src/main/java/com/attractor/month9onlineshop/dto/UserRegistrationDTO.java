package com.attractor.month9onlineshop.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO {

    @NotEmpty(message = "must not be empty")
    @NotNull
    private String username;

    @NotEmpty(message = "must not be empty")
    @NotBlank
    @Email(message = "must be email")
    private String email;

    @NotEmpty(message = "must not be empty")
    @NotNull
    private String password;

    @NotEmpty(message = "must not be empty")
    @NotNull
    private String fullName;

    @NotEmpty(message = "must not be empty")
    @NotNull
    private String captcha;


}
