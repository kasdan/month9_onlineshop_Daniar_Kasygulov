package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.constant.Constants;
import com.attractor.month9onlineshop.dto.BasketDTO;
import com.attractor.month9onlineshop.dto.OrderDTO;
import com.attractor.month9onlineshop.services.BasketService;
import com.attractor.month9onlineshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/order")
    public String getOrder(Model model, Principal principal, HttpSession session){
        System.out.println(principal.getName());
        var orderDTOList = orderService.getOrderListForUser(principal.getName());
        model.addAttribute("baskets",orderDTOList.stream().map(OrderDTO::getBasketDTOwithClothes).collect(Collectors.toList()));
        model.addAttribute("user",principal.getName());
            return "order";
        }

    @PostMapping("/order")
    public String orderPost(@SessionAttribute(name = Constants.BASKET,required = false) List<BasketDTO> basketDTOList, Model model, Principal principal, HttpSession session){
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(BasketDTO basketDTO:basketDTOList){
            var orderDto =orderService.addOrder(basketDTO.getId(),principal.getName());
            orderDTOList.add(orderDto);
        }
        session.setAttribute(Constants.BASKET,new ArrayList<>());
       // model.addAttribute("baskets",orderDTOList.stream().map(OrderDTO::getBasketDTOwithClothes).collect(Collectors.toList()));
       // model.addAttribute("user",principal.getName());
        return "redirect:/order";
    }

    @PostMapping("/order/delete")
    public String orderDelete(Principal principal){
        orderService.deleteOrders(principal.getName());
        return "redirect:/order";
    }

}
