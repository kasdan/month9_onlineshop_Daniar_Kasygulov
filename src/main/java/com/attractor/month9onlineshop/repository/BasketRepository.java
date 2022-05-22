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
    List<Basket> getBasketByUserUserNameAndCurrent(String username,Boolean current);
    void deleteBasketById(Long id);
    Basket getBasketById(Long id);

    @Modifying
    @Query(value = "update baskets set baskets.quantity= :quantity where baskets.id=:basketId",nativeQuery = true)
    void updateQuantity(@Param("basketId") Long basketId, @Param("quantity") Integer quantity );

    @Modifying
    @Query(value = "update baskets set baskets.current= :current where baskets.id=:basketId",nativeQuery = true)
    void updateCurrent(@Param("basketId") Long basketId, @Param("current") Boolean current);

}
