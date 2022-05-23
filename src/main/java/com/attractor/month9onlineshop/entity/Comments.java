package com.attractor.month9onlineshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String commentText;

    @ManyToOne
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
