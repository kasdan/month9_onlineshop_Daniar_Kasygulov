package com.attractor.month9onlineshop.dto;

import com.attractor.month9onlineshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;


}
