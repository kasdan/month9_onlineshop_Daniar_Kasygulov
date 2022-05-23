package com.attractor.month9onlineshop.dto;

import com.attractor.month9onlineshop.entity.Clothes;
import com.attractor.month9onlineshop.entity.Comments;
import lombok.*;

import java.util.List;

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
    private List<Comments> commentsList;

    public static ClothesDTO from(Clothes clothes) {
        return builder()
                .id(clothes.getId())
                .itemName(clothes.getItemName())
                .description(clothes.getDescription())
                .photo(clothes.getPhotos().get(0).getName())
                .price(clothes.getPrice())
                .size(clothes.getSize())
                .quantity(clothes.getQuantity())
                .commentsList(clothes.getComments())
                .build();
    }
}
