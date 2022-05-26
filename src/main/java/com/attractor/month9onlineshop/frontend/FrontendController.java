package com.attractor.month9onlineshop.frontend;

import com.attractor.month9onlineshop.services.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class FrontendController {
    private final ClothesService clothesService;
    private final PropertiesService propertiesService;
    private final MessageSource messageSource;

    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink", constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }
        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink", constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute("clothes", list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }
    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }

    @GetMapping
    public String index(Model model, Pageable pageable, HttpServletRequest uriBuilder, Principal principal, HttpSession session) {
        var clothes = clothesService.getListOfClothes(pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(clothes, propertiesService.getDefaultPageSize(), model, uri);
        Optional<Principal> principalOptional = Optional.ofNullable(principal);
        var map = new HashMap<String, Object>();
        map.put("Идентификатор сессии", session.getId());
        session.getAttributeNames()
                .asIterator()
                .forEachRemaining(key -> map.put(key, session.getAttribute(key).toString()));
        model.addAttribute("sessionAttributes", map);
        if (principalOptional.isPresent()) {
            model.addAttribute("user", principal.getName());
        }
        return "index";
    }

    @GetMapping("/clothes/{id:\\d+?}")
    public String clothesPage(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("cloth", clothesService.getClothesById(Long.valueOf(id)));
        Optional<Principal> principalOptional = Optional.ofNullable(principal);
        if (principalOptional.isPresent()) {
            model.addAttribute("user", principal.getName());
        }
        return "clothes";
    }

    @GetMapping("/advancedSearch")
    public String advancedSearch(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var clothes = clothesService.getListOfClothes(pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(clothes, propertiesService.getDefaultPageSize(), model, uri);
        return "advancedSearch";
    }

    @GetMapping("/name/{name}")
    public String getSearchedClothesByName(@PathVariable String name, Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var clothes = clothesService.getListOfClothesByName(pageable, name);
        var uri = uriBuilder.getRequestURI();
        if (clothes.isEmpty()) {
            model.addAttribute("noInfo", localizeErrorMessage("NoInfo"));
        }
        constructPageable(clothes, propertiesService.getDefaultPageSize(), model, uri);
        return "index";
    }

    @GetMapping("/advancedSearch/name/{name}")
    public String getAdvancedSearchedClothesByName(@PathVariable String name, Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var clothes = clothesService.getListOfClothesByName(pageable, name);
        var uri = uriBuilder.getRequestURI();
        if (clothes.isEmpty()) {
            model.addAttribute("noInfo", localizeErrorMessage("NoInfo"));
        }
        constructPageable(clothes, propertiesService.getDefaultPageSize(), model, uri);
        return "advancedSearch";
    }


    @GetMapping("/advancedSearch/description/{description}")
    public String getSearchedClothesByDescription(@PathVariable String description, Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var clothes = clothesService.getListOfClothesByDescription(pageable, description);
        var uri = uriBuilder.getRequestURI();
        if (clothes.isEmpty()) {
            model.addAttribute("noInfo", localizeErrorMessage("NoInfo"));
        }
        constructPageable(clothes, propertiesService.getDefaultPageSize(), model, uri);
        return "advancedSearch";
    }

    @GetMapping("/advancedSearch/size/{size}")
    public String getSearchedClothesBySize(@PathVariable String size, Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var clothes = clothesService.getListOfClothesBySize(pageable, size);
        var uri = uriBuilder.getRequestURI();
        if (clothes.isEmpty()) {
            model.addAttribute("noInfo", localizeErrorMessage("NoInfo"));
        }
        constructPageable(clothes, propertiesService.getDefaultPageSize(), model, uri);
        return "advancedSearch";
    }

    @GetMapping("/advancedSearch/price/{data}")
    public String getSearchedClothesByPriceRange(@PathVariable String data, Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var min = data.split("and")[0].replace("p", "");
        var max = data.split("and")[1];
        var clothes = clothesService.getListOfClothesByPriceBetween(Double.parseDouble(min), Double.parseDouble(max), pageable);
        var uri = uriBuilder.getRequestURI();
        if (clothes.isEmpty()) {
            model.addAttribute("noInfo", localizeErrorMessage("NoInfo"));
        }
        constructPageable(clothes, propertiesService.getDefaultPageSize(), model, uri);
        return "advancedSearch";
    }
       private String localizeErrorMessage(String errorCode) {
        var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(errorCode, null, locale);
    }

}
