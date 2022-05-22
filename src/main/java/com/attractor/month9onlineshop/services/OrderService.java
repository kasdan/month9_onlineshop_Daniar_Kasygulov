package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.dto.BasketDTO;
import com.attractor.month9onlineshop.dto.OrderDTO;
import com.attractor.month9onlineshop.entity.Basket;
import com.attractor.month9onlineshop.entity.Order;
import com.attractor.month9onlineshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final BasketService basketService;

    public OrderDTO addOrder(Long basketId, String username){
        var basket = basketService.getBasketById(basketId);
        var user = userService.getUserByUserName(username);
        var order = Order.builder()
                .basket(basket)
                .user(user)
                .build();
        orderRepository.save(order);
        basketService.changeBasketCurrentById(basket.getId());
        return OrderDTO.from(order);
    }

    public List<OrderDTO> getOrderListForUser(String username){
        var user = userService.getUserByUserName(username);
        var orders = orderRepository.findOrdersByUserId(user.getId()).stream().map(OrderDTO::from).collect(Collectors.toList());
        System.out.println(orders);
       return orders;
    }
}
