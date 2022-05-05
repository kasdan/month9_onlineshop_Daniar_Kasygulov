package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review,String> {
}
