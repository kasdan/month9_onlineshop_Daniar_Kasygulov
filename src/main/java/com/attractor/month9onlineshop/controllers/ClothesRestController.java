package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.dto.ClothesDTO;
import com.attractor.month9onlineshop.services.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClothesRestController {
    private final ClothesService clothesService;

    @GetMapping("/clothes")
    public List<ClothesDTO> getAllClothes(Pageable pageable){
        return clothesService.getListOfClothes(pageable).getContent();
    }

    @GetMapping("/clothes/name/{name}")
    public List<ClothesDTO> getClothesByName(@PathVariable String name,Pageable pageable){
        return clothesService.getListOfClothesByName(pageable,name).getContent();
    }

    @GetMapping("/clothes/description/{description}")
    public List<ClothesDTO> getClothesByDescription(@PathVariable String description,Pageable pageable){
        return clothesService.getListOfClothesByDescription(pageable,description).getContent();
    }

    @GetMapping("clothes/size/{size}")
    public List<ClothesDTO> getClothesBySize(@PathVariable String size,Pageable pageable){
        return clothesService.getListOfClothesBySize(pageable,size).getContent();
    }
 }
