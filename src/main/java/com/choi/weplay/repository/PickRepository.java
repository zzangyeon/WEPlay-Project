package com.choi.weplay.repository;

import com.choi.weplay.domain.Pick;
import com.choi.weplay.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PickRepository extends JpaRepository<Pick, Integer> {

    @Query(value = "select p from Pick p join fetch p.place where p.user.id = :id")
    List<Pick> findByUserIdWithPlace(int id);

}
