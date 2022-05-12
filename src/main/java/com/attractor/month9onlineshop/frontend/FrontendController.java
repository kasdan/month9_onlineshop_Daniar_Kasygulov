package com.attractor.month9onlineshop.frontend;

import com.attractor.month9onlineshop.services.ClothesService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    private final ClothesService clothesService;

    private final PropertiesService propertiesService;

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
    public String index(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var clothes = clothesService.getListOfClothes(pageable);
        var uri = uriBuilder.getRequestURI();

        constructPageable(clothes, propertiesService.getDefaultPageSize(), model, uri);

        return "index";
    }

    @GetMapping("/advancedSearch")
    public String advancedSearch(Model model,Pageable pageable,HttpServletRequest uriBuilder){
        return "advancedSearch";
    }
    @GetMapping("/name/{name}")
    public String getSearchedPlaces(@PathVariable String name, Model model, Pageable pageable, HttpServletRequest uriBuilder){
        var places = clothesService.getListOfClothesByName(pageable,name);
        var uri = uriBuilder.getRequestURI();
        if(places.isEmpty()){
            model.addAttribute("noInfo","Cannot find any clothes");
        }
        constructPageable(places,propertiesService.getDefaultPageSize(),model,uri);
        return "advancedSearch";
    }
//
//    @GetMapping("/places/{id:\\d+?}")
//    public String placePage(@PathVariable int id, Model model, Pageable pageable, HttpServletRequest uriBuilder) {
//        model.addAttribute("place", placeService.getPlace(id));
//        var uri = uriBuilder.getRequestURI();
//        var foods = foodService.getFoods(id, pageable);
//        constructPageable(foods, propertiesService.getDefaultPageSize(), model, uri);
//
//        return "place";
//    }
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    private String handleRNF(ResourceNotFoundException ex, Model model) {
//        model.addAttribute("resource", ex.getResource());
//        model.addAttribute("id", ex.getId());
//        return "resource-not-found";
//    }

}
