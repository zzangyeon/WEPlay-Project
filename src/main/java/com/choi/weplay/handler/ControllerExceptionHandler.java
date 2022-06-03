package com.choi.weplay.handler;

import com.choi.weplay.handler.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 발생하는 모든 exception에 대한 처리자.
public class ControllerExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(CustomException e) {

        HttpHeaders responseHeader = new HttpHeaders();
        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("error code", e.getMessage());

        return new ResponseEntity<>(map, responseHeader, e.getHttpStatus());
    }
}
