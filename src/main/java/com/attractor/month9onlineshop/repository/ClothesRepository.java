package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes,Long> {
    Page<Clothes> findClothesByItemNameContaining(Pageable pageable, String name);
    Page<Clothes> findClothesByDescriptionContaining(Pageable pageable,String description);
    Page<Clothes> findClothesBySizeContains(Pageable pageable,String size);
}
