package com.choi.weplay.service;

import com.choi.weplay.domain.Place;
import com.choi.weplay.domain.User;
import com.choi.weplay.repository.PlaceRepository;
import com.choi.weplay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User getUser(int id) {
        log.info("Get Place List 진행");
        return userRepository.findById(id);
    }
}
