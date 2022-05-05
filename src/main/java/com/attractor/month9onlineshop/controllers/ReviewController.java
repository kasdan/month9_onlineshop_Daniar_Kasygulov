package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
}
