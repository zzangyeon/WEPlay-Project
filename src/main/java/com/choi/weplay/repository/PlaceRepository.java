package com.choi.weplay.repository;

import com.choi.weplay.domain.Place;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findByRegion(String region);

    @EntityGraph(attributePaths = {"items"})
    Place findById(int id);

}
