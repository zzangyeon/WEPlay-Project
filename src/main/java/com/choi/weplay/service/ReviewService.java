package com.choi.weplay.service;

import com.choi.weplay.domain.Review;
import com.choi.weplay.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public List<Review> getReviewListByPlaceId(int placeId) {
        log.info("Get ReviewList By PlaceId 진행");
        return reviewRepository.findByPlaceId(placeId);
    }

    @Transactional(readOnly = true)
    public List<Review> getReviewListByUserId(int userId) {
        log.info("Get ReviewList By userId With Place 진행");
        return reviewRepository.findByUserIdWithPlace(userId);
    }

}
