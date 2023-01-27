package com.melita.order.controller;

import com.melita.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${status}")
    private String statusMessage;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<String>(statusMessage, HttpStatus.OK);
    }
}
