package com.choi.weplay.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam String name) {
        return ResponseEntity.ok("hello " + name);
    }

}
