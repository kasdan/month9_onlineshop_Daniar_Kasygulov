package com.attractor.month9onlineshop.services;

import com.attractor.month9onlineshop.entity.User;
import com.attractor.month9onlineshop.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Service
@RequiredArgsConstructor
public class RestorePasswordService {
    private final UserService userService;
    private final Map<String,String> localHash = new HashMap<>();
    private final AuthenticationManager authManager;
    private final PasswordEncoder encoder;

    public String restorePassword(String email){

        var user = userService.findUserByEmail(email);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        String hash = generateRandomLink(user.get());
        user.get().setPassword(encoder.encode(hash));
        userService.changeUserPassword(user.get());
        return hash;

    }

    private String generateRandomLink(User user){
        String link = UUID.randomUUID().toString().split("-")[0];
        localHash.put(user.getUserName(), link);
        return link;
    }

    public void changePassword(String hash, HttpServletRequest req) {
        User user = getUserByHash(hash);
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(user.getUserName(),hash);
        Authentication auth = authManager.authenticate(authReq);
        System.out.println(auth.getPrincipal());
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = req.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);

    }
    private User getUserByHash(String hash){
        for (Map.Entry<String,String> pair:localHash.entrySet()){
            if(pair.getValue().equals(hash)){
              User user = userService.getUserByUserName(pair.getKey());
              localHash.remove(pair.getKey());
              return user;
            }
        }
        throw new UserNotFoundException();
    }
}
