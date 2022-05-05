package com.attractor.month9onlineshop.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="basket_id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
