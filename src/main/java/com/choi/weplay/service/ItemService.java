package com.choi.weplay.service;

import com.choi.weplay.domain.Item;
import com.choi.weplay.domain.Place;
import com.choi.weplay.repository.ItemRepository;
import com.choi.weplay.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public Item getItem(int id) {
        log.info("Get Item 진행");
        return itemRepository.findById(id);
    }

}
