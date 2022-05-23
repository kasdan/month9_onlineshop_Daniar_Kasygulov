package com.attractor.month9onlineshop.dto;

import com.attractor.month9onlineshop.entity.Basket;
import com.attractor.month9onlineshop.entity.Clothes;
import com.attractor.month9onlineshop.entity.Comments;
import com.attractor.month9onlineshop.services.CommentsService;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasketDTOwithClothes {
    private Long id;
    private ClothesDTO clothes;
    private Integer quantity;

    public static  BasketDTOwithClothes from(Basket basket){
        return builder()
                .id(basket.getId())
                .clothes(ClothesDTO.from(basket.getClothes()))
                .quantity(basket.getQuantity())
                .build();
    }
}
