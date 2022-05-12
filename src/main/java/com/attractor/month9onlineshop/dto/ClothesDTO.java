package com.attractor.month9onlineshop.dto;

import com.attractor.month9onlineshop.entity.Clothes;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClothesDTO {
    private Long id;
    private String itemName;
    private String description;
    private Integer quantity;
    private String size;
    private Double price;
    private String photo;

    public static ClothesDTO from(Clothes clothes) {
        return builder()
                .id(clothes.getId())
                .itemName(clothes.getItemName())
                .description(clothes.getDescription())
                .photo(clothes.getPhotos().get(0).getName())
                .price(clothes.getPrice())
                .size(clothes.getSize())
                .build();
    }
}
