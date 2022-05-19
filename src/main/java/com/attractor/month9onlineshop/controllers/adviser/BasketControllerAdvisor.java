package com.attractor.month9onlineshop.controllers.adviser;

import com.attractor.month9onlineshop.constant.Constants;
import com.attractor.month9onlineshop.dto.BasketDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class BasketControllerAdvisor {
    @ModelAttribute(Constants.BASKET)
    public List<BasketDTO> getBasketModel(HttpSession session) {
        var list = session.getAttribute(Constants.BASKET);
        if (list == null) {
            session.setAttribute(Constants.BASKET, new ArrayList<>());
        }
        return (List<BasketDTO>) session.getAttribute(Constants.BASKET);
    }

}
