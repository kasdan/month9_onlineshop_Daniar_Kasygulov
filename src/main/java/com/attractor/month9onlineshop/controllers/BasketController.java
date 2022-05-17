package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.dto.BasketAddDTO;
import com.attractor.month9onlineshop.dto.BasketDTO;
import com.attractor.month9onlineshop.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping("/clothes/{id:\\d+?}")
    public String addToBasket(@PathVariable int id, @Valid BasketAddDTO basketAddDTO, Model model,Principal principal){
        var basket = basketService.addToBasket(Long.parseLong(basketAddDTO.getClothesId()),principal.getName(), Integer.parseInt(basketAddDTO.getQuantity()));
        model.addAttribute("basket",basket.toString());
        model.addAttribute("user","user");
        return "clothes/"+id;
    }

}
