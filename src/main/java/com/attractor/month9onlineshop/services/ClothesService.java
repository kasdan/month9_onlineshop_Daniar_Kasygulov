package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.entity.Clothes;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesRepository clothesRepository;

    public List<Clothes> getListOfClothes(){
        List<Clothes> clothes = new ArrayList<>();
        clothesRepository.findAll().forEach(clothes::add);
        return clothes;
    }
}
