package com.choi.weplay.controller;

import com.choi.weplay.domain.Buy;
import com.choi.weplay.domain.Pick;
import com.choi.weplay.domain.Review;
import com.choi.weplay.domain.User;
import com.choi.weplay.service.PlaceService;
import com.choi.weplay.service.ReviewService;
import com.choi.weplay.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ReviewService reviewService;

    @GetMapping("/user/{id}")
    public String mypage(@PathVariable int id, Model model) {
        log.info("마이페이지 접속 진행");
        model.addAttribute("user", userService.getUser(id));
        return "mypage";
    }

    @ResponseBody
    @GetMapping("/api/user/{id}/buy")
    public List<Buy> mypageBuy(@PathVariable int id, Model model) {
        log.info("API User BuyList 접속 진행");
        return userService.getBuyList(id);
    }

    @ResponseBody
    @GetMapping("/api/user/{id}/review")
    public List<Review> mypageReview(@PathVariable int id, Model model) {
        log.info("API User ReviewList 접속 진행");
        return reviewService.getReviewListByUserId(id);
    }

    @ResponseBody
    @GetMapping("/api/user/{id}/pick")
    public List<Pick> mypagePick(@PathVariable int id, Model model) {
        log.info("API User PickList 접속 진행");
        return userService.getPickList(id);
    }


}
