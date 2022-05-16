package com.attractor.month9onlineshop.dto;

import com.attractor.month9onlineshop.entity.Clothes;
import com.attractor.month9onlineshop.entity.User;
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
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String fullName;

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .username(user.getUserName())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();
    }
}
