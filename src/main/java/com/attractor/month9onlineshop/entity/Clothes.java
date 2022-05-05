package com.attractor.month9onlineshop.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "clothes")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item_name")
    private String itemName;

    @OneToMany(mappedBy = "clothes", cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<Photo> photos = new java.util.ArrayList<>();

    @Column(name="description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "size")
    private String size;

    @Column(name = "date_time_added")
    private LocalDateTime dateAdded;

}

