package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
}
