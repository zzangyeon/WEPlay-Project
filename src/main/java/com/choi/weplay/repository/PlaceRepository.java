package com.choi.weplay.repository;

import com.choi.weplay.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findByRegion(String region);

    Place findById(int id);

}
