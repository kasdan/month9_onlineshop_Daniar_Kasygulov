package com.attractor.month9onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotEmpty
    private String username;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String fullName;
}
