package com.choi.weplay.repository;

import com.choi.weplay.domain.Buy;
import com.choi.weplay.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyRepository extends JpaRepository<Buy, Integer> {

    @Query(value = "select b from Buy b join fetch b.place where b.user.id=:id")
    List<Buy> findByUserIdWithPlace(int id);

}
