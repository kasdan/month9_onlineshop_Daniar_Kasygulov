package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.dto.BasketAddDTO;
import com.attractor.month9onlineshop.dto.BasketDTO;
import com.attractor.month9onlineshop.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping("/clothes/{id:\\d+?}")
    public String addToBasket(@PathVariable int id, @Valid BasketAddDTO basketAddDTO,Principal principal,Model model){
        var basket = basketService.addToBasket(Long.parseLong(basketAddDTO.getClothesId()),principal.getName(), Integer.parseInt(basketAddDTO.getQuantity()));
        model.addAttribute("basket",basket);
        return "redirect:/clothes/"+id;
    }

    @GetMapping("/basket")
    public String getBasket(Model model,Principal principal){
        var basketList = basketService.getBasketForUser(principal.getName());
        model.addAttribute("baskets",basketList);
        model.addAttribute("user",principal.getName());
        return "/basket";
    }

}
