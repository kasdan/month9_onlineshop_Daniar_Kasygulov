package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.services.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class ClothesController {
    private final ClothesService clothesService;

    @GetMapping("/clothes")
    public String getAllClothes(Model model){
        model.addAttribute("clothes",clothesService.getListOfClothes());
        return "clothes";
    }
}
