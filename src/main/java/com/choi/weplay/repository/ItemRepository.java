package com.choi.weplay.repository;

import com.choi.weplay.domain.Buy;
import com.choi.weplay.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Item findById(int id);

}
