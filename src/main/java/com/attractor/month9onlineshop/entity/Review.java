package com.attractor.month9onlineshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "text", length = 2000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
