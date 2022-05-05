package com.attractor.month9onlineshop.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "baskets")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "basket", orphanRemoval = true)
    private List<Clothes> clothes = new java.util.ArrayList<>();
}
