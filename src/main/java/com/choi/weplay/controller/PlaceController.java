package com.choi.weplay.controller;

import com.choi.weplay.domain.Place;
import com.choi.weplay.service.PlaceService;
import com.choi.weplay.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final ReviewService reviewService;

    @GetMapping("/")
    public String place(Model model) {
        log.info("home 접속 진행");
        model.addAttribute("places", placeService.getPlaceList("강남구"));
        model.addAttribute("region","강남구");
        return "home";
    }

    @GetMapping("/place/{id}")
    public String placeDetail(@PathVariable int id, Model model) {
        log.info("place detail 접속 진행");
        model.addAttribute("reviews", reviewService.getReviewList(id));
        model.addAttribute("place", placeService.getPlace(id));
        return "detail";
    }


}