package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User,String> {
    User findUserByUserName(String username);

}
