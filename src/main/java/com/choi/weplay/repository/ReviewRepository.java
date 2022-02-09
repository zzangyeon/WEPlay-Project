package com.choi.weplay.repository;

import com.choi.weplay.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByPlaceId(int placeId);
}
