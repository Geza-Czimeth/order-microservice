package com.melita.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    @Value("${rabbitmq.routing.order}")
    private String exchangeName;

    @Value("${rabbitmq.topic.order}")
    private String orderTopic;

    @Value("${rabbitmq.queue.fulfilment}")
    private String fulfilmentQueue;

    @Value("${rabbitmq.queue.care}")
    private String careQueue;

    @Bean
    public Queue allQueue() {
        return new Queue(fulfilmentQueue, true);
    }

    @Bean
    public Queue adminQueue() {
        return new Queue(careQueue, true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding adminBinding(Queue adminQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(adminQueue).to(topicExchange).with(orderTopic);
    }

    @Bean
    public Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(allQueue).to(topicExchange).with(orderTopic);
    }
}
