package com.melita.order.publisher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RabbitMQTopicProducerTest {

    private static final String TEST_MESSAGE = "test message";
    private static final String EXCHANGE_NAME = "exchangeName";
    private static final String ORDER_TOPIC = "orderTopic";

    @Mock
    private RabbitTemplate rabbitTemplate;
    private RabbitMQTopicProducer rabbitMQTopicProducer;

    @BeforeEach
    public void setup() {
        rabbitMQTopicProducer = new RabbitMQTopicProducer(rabbitTemplate, EXCHANGE_NAME, ORDER_TOPIC);
    }

    @Test
    public void sendMessageUsesTemplate() {
        rabbitMQTopicProducer.sendMessage(TEST_MESSAGE);
        verify(rabbitTemplate).convertAndSend(EXCHANGE_NAME, ORDER_TOPIC, TEST_MESSAGE);
    }
}
