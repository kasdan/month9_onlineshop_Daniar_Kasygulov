package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,String> {
    User findUserByUserName(String username);
}
