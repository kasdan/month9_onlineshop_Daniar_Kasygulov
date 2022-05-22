package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Basket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends PagingAndSortingRepository<Basket,String> {
    List<Basket> getBasketByUserUserName(String username);
    void deleteBasketById(Long id);

    @Modifying
    @Query(value = "update baskets set baskets.quantity= :quantity where baskets.id=:basketId",nativeQuery = true)
    int updateQuantity(@Param("basketId") Long basketId, @Param("quantity") Integer quantity );
}
