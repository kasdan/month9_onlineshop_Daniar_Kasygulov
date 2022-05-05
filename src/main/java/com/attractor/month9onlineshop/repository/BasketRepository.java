package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Basket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends PagingAndSortingRepository<Basket,String> {

}
