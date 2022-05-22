package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestorePasswordService {
    private final UserService userService;
    private final Map<String,String> localHash = new HashMap<>();

    public String restorePassword(String email){
        var user = userService.findUserByEmail(email);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        return generateRandomLink(user.get());
    }

    private String generateRandomLink(User user){
        UUID uuid = UUID.randomUUID();
        localHash.put(user.getUserName(), uuid.toString());
        return uuid.toString();
    }

    public void changePassword(String hash) {
        for (Map.Entry<String,String> hashVal:localHash.entrySet()){
            if(hashVal.getValue().equals(hash)){

            }
        }
    }
}
