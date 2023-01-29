package com.melita.order.service.impl;

import com.melita.order.model.Order;
import com.melita.order.publisher.RabbitMQTopicProducer;
import com.melita.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RabbitMQTopicProducer rabbitMQTopicProducer;

    @Override
    public void takeOrder(Order order) {
        log.info("Order processed {}", order);
        rabbitMQTopicProducer.sendMessage(order.toString());
    }
}
