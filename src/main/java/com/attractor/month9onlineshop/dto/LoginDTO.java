package com.attractor.month9onlineshop.dto;

import com.attractor.month9onlineshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String username;
    private String password;


}
