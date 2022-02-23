package com.choi.weplay.repository;

import com.choi.weplay.domain.Place;
import com.choi.weplay.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

}
