package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order,String> {
    List<Order> findOrdersByUserId(Long userId);
//    @Query(value = "INSERT INTO orders (basket_id, user_id) VALUES ('2', '2')",nativeQuery = true)
//    void inertIntoOrders(@Param("basketId") Long basketId, @Param("current") Boolean current);
}
