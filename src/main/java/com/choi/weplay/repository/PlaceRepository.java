package com.choi.weplay.repository;

import com.choi.weplay.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findByRegion(String region);

    @Query(value = "SELECT p FROM Place p left join p.items i ON p.id = i.place.id WHERE p.id = :id")
    Place findByIdWithItems(int id);

}
