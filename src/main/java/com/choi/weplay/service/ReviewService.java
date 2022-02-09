package com.choi.weplay.service;

import com.choi.weplay.domain.Review;
import com.choi.weplay.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getReviewList(int placeId) {
        log.info("Get Review List 진행");
        return reviewRepository.findByPlaceId(placeId);
    }
}
