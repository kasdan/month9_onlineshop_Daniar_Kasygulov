package com.attractor.month9onlineshop.controllers;

import com.attractor.month9onlineshop.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;
}
