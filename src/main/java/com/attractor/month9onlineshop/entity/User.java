package com.attractor.month9onlineshop.entity;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="user_name")
    private String userName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="full_name")
    private String fullName;
}
