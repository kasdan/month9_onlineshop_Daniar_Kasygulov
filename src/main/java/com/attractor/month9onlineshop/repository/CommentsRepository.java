package com.attractor.month9onlineshop.repository;

import com.attractor.month9onlineshop.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> getCommentsByClothes_Id(Long id);
}
