package com.attractor.month9onlineshop.dto;

import com.attractor.month9onlineshop.entity.Order;
import com.attractor.month9onlineshop.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDTO {
    private Long id;
    private BasketDTOwithClothes basketDTOwithClothes;
    private UserDTO userDTO;

    public static OrderDTO from(Order order) {
        BasketDTOwithClothes basketDTOwithClothes = BasketDTOwithClothes.from(order.getBasket());
        UserDTO userDTO = UserDTO.from(order.getUser());
        return builder()
                .userDTO(userDTO)
                .basketDTOwithClothes(basketDTOwithClothes)
                .build();
    }
}
