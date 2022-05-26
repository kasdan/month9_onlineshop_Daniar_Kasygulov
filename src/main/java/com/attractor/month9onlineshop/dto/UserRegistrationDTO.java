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

    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotEmpty
    @NotNull
    private String password;

    @NotEmpty
    @NotNull
    private String fullName;

    @NotEmpty
    @NotNull
    private String captcha;


}
