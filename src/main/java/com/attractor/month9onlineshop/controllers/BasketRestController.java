package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.services.BasketService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
public class BasketRestController {
    private final BasketService basketService;

    @GetMapping("/add")
    public String addToTheBasket(P)
}
