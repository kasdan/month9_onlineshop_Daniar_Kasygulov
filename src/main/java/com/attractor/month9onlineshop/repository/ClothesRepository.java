package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Clothes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends PagingAndSortingRepository<Clothes,String> {

}
