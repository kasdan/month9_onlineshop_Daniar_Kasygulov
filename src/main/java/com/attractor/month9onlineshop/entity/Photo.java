package com.attractor.month9onlineshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "photos")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;

}
