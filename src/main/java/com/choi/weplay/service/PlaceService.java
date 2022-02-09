package com.choi.weplay.service;

import com.choi.weplay.domain.Place;
import com.choi.weplay.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository storeRepository;

    @Transactional
    public List<Place> getPlaceList(String region) {
        log.info("Get Place List 진행");
        return storeRepository.findByRegion(region);
    }

    @Transactional
    public Place getPlace(int id) {
        log.info("Get Place 진행");
        return storeRepository.findById(id);
    }



}
