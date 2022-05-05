package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.services.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClothesController {
    private final ClothesService clothesService;
}
