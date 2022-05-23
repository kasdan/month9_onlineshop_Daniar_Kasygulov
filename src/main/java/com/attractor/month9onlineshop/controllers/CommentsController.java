package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.entity.Comments;
import com.attractor.month9onlineshop.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CommentsController {
    private final CommentsService commentsService;

    @PostMapping("/comments")
    public String addComments(@RequestParam(name="comments") String comments,@RequestParam(name="clothes_id") Long clothesId,Principal principal){
        System.out.println(clothesId);
        commentsService.addComments(comments,clothesId,principal.getName());
        return "redirect:/order";
    }

}
