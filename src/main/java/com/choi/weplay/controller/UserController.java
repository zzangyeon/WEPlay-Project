package com.choi.weplay.controller;

import com.choi.weplay.service.PlaceService;
import com.choi.weplay.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final PlaceService placeService;
    private final ReviewService reviewService;


    @GetMapping("/user/{id}")
    public String homeByRegion(@PathVariable int id, Model model) {
        log.info("마이페이지 접속 진행");
        /*model.addAttribute("region",name);
        model.addAttribute("places", placeService.getPlaceList(name));*/
        return "mypage";
    }

}
