package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User,String> {
    User findUserByUserName(String username);
    Optional<User> findUserByEmail(String email);
    @Modifying
    @Query(value = "update users set users.password= :password where users.id=:userId",nativeQuery = true)
    void updatePassword(@Param("userId") Long userId, @Param("password") String password);

}
