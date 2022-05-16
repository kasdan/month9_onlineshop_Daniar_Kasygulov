package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
}
