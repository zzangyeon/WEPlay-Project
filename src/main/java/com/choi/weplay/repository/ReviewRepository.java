package com.choi.weplay.repository;

import com.choi.weplay.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByPlaceId(int placeId);

    @Query(value = "select r from Review r join fetch r.place where r.user.id = :id")
    List<Review> findByUserIdWithPlace(int id);
}
