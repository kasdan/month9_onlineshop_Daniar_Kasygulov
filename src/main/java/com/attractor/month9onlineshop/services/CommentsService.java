package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.entity.Comments;
import com.attractor.month9onlineshop.repository.CommentsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final UserService userService;
    private final ClothesService clothesService;

    public void addComments(String comments, Long clothesId, String name) {
        var user = userService.getUserByUserName(name);
        var clothes = clothesService.getClothesByIdEntity(clothesId);
        var com = Comments.builder()
                .commentText(comments)
                .clothes(clothes)
                .user(user)
                .build();
        commentsRepository.save(com);
    }

    public List<Comments> getCommentsList(Long clothesId) {
        return commentsRepository.getCommentsByClothes_Id(clothesId);
    }
}
