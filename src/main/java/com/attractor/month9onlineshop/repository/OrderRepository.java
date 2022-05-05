package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order,String> {
}
