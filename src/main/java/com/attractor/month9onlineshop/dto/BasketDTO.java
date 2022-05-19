package com.attractor.month9onlineshop.dto;

import com.attractor.month9onlineshop.entity.Basket;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasketDTO {
    private Long id;
    private Long clothesId;
    private Long userId;
    private Integer quantity;

    public static BasketDTO from(Basket basket){
        return builder()
                .id(basket.getId())
                .clothesId(basket.getClothes().getId())
                .userId(basket.getUser().getId())
                .quantity(basket.getQuantity())
        .build();
    }
}
