package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.dto.ClothesDTO;
import com.attractor.month9onlineshop.entity.Clothes;
import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesRepository clothesRepository;

    public Page<ClothesDTO> getListOfClothes(Pageable pageable){
        return  clothesRepository.findAll(pageable).map(ClothesDTO::from);
    }

    public Page<ClothesDTO> getListOfClothesByName(Pageable pageable,String name){
        return clothesRepository.findClothesByItemNameContaining(pageable,name).map(ClothesDTO::from);
    }

    public Page<ClothesDTO> getListOfClothesByDescription(Pageable pageable,String description){
        return clothesRepository.findClothesByDescriptionContaining(pageable,description).map(ClothesDTO::from);
    }

    public Page<ClothesDTO> getListOfClothesBySize(Pageable pageable,String size){
        return clothesRepository.findClothesBySizeContains(pageable,size).map(ClothesDTO::from);
    }

}
