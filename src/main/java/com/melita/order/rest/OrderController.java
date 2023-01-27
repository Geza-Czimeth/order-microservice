package com.melita.order.rest;

import com.melita.order.dto.OrderDTO;
import com.melita.order.rest.assembler.OrderModelAssembler;
import com.melita.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderModelAssembler orderModelAssembler;

    @Value("${status}")
    private String statusMessage;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>(statusMessage, OK);
    }

    @PostMapping(value = "${order.url.takeorder}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> takeOrder(@Valid @RequestBody OrderDTO orderDTO) {
        log.info("order received: " + orderDTO);
        orderService.takeOrder(orderModelAssembler.assemble(orderDTO));
        return new ResponseEntity<>("Order taken", OK);
    }
}
