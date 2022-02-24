package com.choi.weplay.controller;

import com.choi.weplay.domain.Item;
import com.choi.weplay.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final ItemService itemService;

    @ResponseBody
    @GetMapping("/api/payment/{id}")
    public Item paymentTest(@PathVariable int id) {
        log.info("Payment Item API 통신 진행");
        return itemService.getItem(id);
    }

}
