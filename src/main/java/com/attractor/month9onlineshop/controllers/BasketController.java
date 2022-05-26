package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.constant.Constants;
import com.attractor.month9onlineshop.dto.BasketAddDTO;
import com.attractor.month9onlineshop.dto.BasketDTO;
import com.attractor.month9onlineshop.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping("/clothes/{id:\\d+?}")
    public String addToBasket(@PathVariable int id, @Valid BasketAddDTO basketAddDTO, Principal principal, Model model
            ,HttpSession session, HttpServletRequest req){
         BasketDTO basket;
         Optional<Principal> principalOptional = Optional.ofNullable(principal);
        if(principalOptional.isPresent()) {
            basket = basketService.addToBasket(Long.parseLong(basketAddDTO.getClothesId()), principal.getName(), Integer.parseInt(basketAddDTO.getQuantity()));
        }else{
            var sessionId = session.getId();
            basket = basketService.addToBasketOfAnonymousUser(basketAddDTO.getClothesId(),sessionId, Integer.parseInt(basketAddDTO.getQuantity()),req);
        }
        if (session != null) {
            var attr = session.getAttribute(Constants.BASKET);
            if (attr == null) {
                session.setAttribute(Constants.BASKET, new ArrayList<BasketDTO>());
            }
            try {
                var list = (List<BasketDTO>) session.getAttribute(Constants.BASKET);
                list.add(basket);
            }
            catch (ClassCastException ignored) {
            }
        }
        model.addAttribute("basket",basket);
        return "redirect:/";
    }

    @GetMapping("/basket")
    public String getBasket( @RequestParam(name = "quantity",required = false) String quantity,
                             @RequestParam(name = "basketId",required = false) String basketId,
                             Model model, Principal principal,HttpSession session,
                             @SessionAttribute(name = Constants.BASKET,required = false) List<BasketDTO> basketDTOList){

        if(basketId!=null & quantity==null) {
            basketService.deleteBasketInstanceById(basketId);
            var basketDTO = basketDTOList.stream().filter(e->e.getId() == Long.parseLong(basketId)).findFirst();
            if(basketDTO.isPresent()) {
                basketDTOList.remove(basketDTO.get());
                session.setAttribute(Constants.BASKET,basketDTOList);
            }
        }
        else if(basketId!=null & quantity!=null) {
            basketService.changeBasketQuantity(basketId,quantity);
        }
        var map = new HashMap<String, Object>();
        session.getAttributeNames()
                .asIterator()
                .forEachRemaining(key -> map.put(key, session.getAttribute(key).toString()));
        model.addAttribute("sessionAttributes", map);
        var basketList = basketService.getBasketForUser(principal.getName());
        model.addAttribute("baskets",basketList);
        model.addAttribute("user",principal.getName());
        return "/basket";
    }
//    @PostMapping("/basket")
//    public String deleteBasketInstance(@RequestBody Long basketId, Model model, Principal principal){
//        //basketService.deleteBasketInstanceById(basketId);
//        var basketList = basketService.getBasketForUser(principal.getName());
//        model.addAttribute("baskets",basketList);
//        model.addAttribute("user",principal.getName());
//        return "/basket";
//    }
}
