package com.attractor.month9onlineshop.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CapchaService {
    private String capcha;

    public String getNewCapcha(){
        setCapcha(UUID.randomUUID().toString());
        return getCapcha();
    }

    public Boolean checkCapcha(String cap){
        return getCapcha().equals(cap);
    }
}
