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
public class UserDTO {
    private String username;
    private String email;
    private String fullName;

    public static UserDTO from(User user) {
        return builder()
                .username(user.getUserName())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();
    }
}
