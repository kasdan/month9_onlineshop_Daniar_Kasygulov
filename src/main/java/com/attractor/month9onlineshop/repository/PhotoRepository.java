package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Photo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends PagingAndSortingRepository<Photo,String> {
}
