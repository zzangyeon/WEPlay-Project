package com.choi.weplay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class TestController {

    @PostMapping("/ex")
    public void exceptionTest() throws Exception {
        throw new Exception();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String,String>> exceptionHandler(Exception e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpstatus = HttpStatus.BAD_REQUEST;

        log.info("controller 내 ExceptionHandler 호출");
        log.info(e.getLocalizedMessage());

        Map<String, String> map = new HashMap<>();
        map.put("erro type", httpstatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpstatus);
    }



}
