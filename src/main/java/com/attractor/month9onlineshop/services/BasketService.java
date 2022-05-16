package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.entity.Basket;
import com.attractor.month9onlineshop.entity.Clothes;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.repository.BasketRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final UserService userService;
    private final ClothesService clothesService;

    public void addToBasket(Long clothesId, String username, Integer quantity){
        var user = userService.getUserByUserName(username);
        var clothes = clothesService.getClothesByIdEntity(clothesId);
        var basket = Basket.builder()
                .user(user)
                .clothes(clothes)
                .quantity(quantity)
                .build();
    }
}
