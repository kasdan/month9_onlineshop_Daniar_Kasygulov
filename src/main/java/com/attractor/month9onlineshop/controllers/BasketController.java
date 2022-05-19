package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.dto.BasketAddDTO;
import com.attractor.month9onlineshop.dto.BasketDTO;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping("/clothes/{id:\\d+?}")
    public String addToBasket(@PathVariable int id, @Valid BasketAddDTO basketAddDTO,Principal principal,Model model,HttpSession session){
        var basket = basketService.addToBasket(Long.parseLong(basketAddDTO.getClothesId()),principal.getName(), Integer.parseInt(basketAddDTO.getQuantity()));
        if (session != null) {
            var attr = session.getAttribute("basket");
            if (attr == null) {
                session.setAttribute("basket", new ArrayList<BasketDTO>());

            }
            try {
                var list = (List<BasketDTO>) session.getAttribute("basket");
                list.add(basket);
            } catch (ClassCastException ignored) {

            }
        }

        model.addAttribute("basket",basket);
        System.out.println(session.getAttribute("basket"));
        return "redirect:/clothes/"+id;
    }

    @GetMapping("/basket")
    public String getBasket(Model model, Principal principal){
        var basketList = basketService.getBasketForUser(principal.getName());
        model.addAttribute("baskets",basketList);
        model.addAttribute("user",principal.getName());
        return "/basket";
    }

}
