package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.dto.BasketDTO;
import com.attractor.month9onlineshop.dto.BasketDTOwithClothes;
import com.attractor.month9onlineshop.entity.Basket;
import com.attractor.month9onlineshop.entity.Clothes;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.repository.BasketRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final UserService userService;
    private final ClothesService clothesService;

    public BasketDTO addToBasket(Long clothesId, String username, Integer quantity){
        var user = userService.getUserByUserName(username);
        var clothes = clothesService.getClothesByIdEntity(clothesId);
        var basket = Basket.builder()
                .user(user)
                .clothes(clothes)
                .quantity(quantity)
                .build();
        basketRepository.save(basket);
        return BasketDTO.from(basket);
    }

    public List<BasketDTOwithClothes> getBasketForUser(String username){
        var basketDTOList = basketRepository.getBasketByUserUserName(username)
                .stream().map(BasketDTOwithClothes::from).collect(Collectors.toList());
        return basketDTOList;
    }
}
