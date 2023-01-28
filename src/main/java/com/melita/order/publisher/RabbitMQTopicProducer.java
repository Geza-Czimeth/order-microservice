package com.melita.order.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQTopicProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;
    private final String orderTopic;

    @Autowired
    public RabbitMQTopicProducer(RabbitTemplate rabbitTemplate, @Value("${rabbitmq.routing.order}") String exchangeName, @Value("${rabbitmq.topic.order}") String orderTopic) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = exchangeName;
        this.orderTopic = orderTopic;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchangeName, orderTopic, message);
        log.info(String.format("Message sent --> %s", message));
    }
}
