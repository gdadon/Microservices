package com.guy.microservice1.config;

import com.guy.microservice1.producer.Producer;
import com.guy.microservice1.producer.RabbitMQProducer;
import com.guy.microservice1.services.PublisherService;
import com.guy.microservice1.services.PublisherServiceRabbitMQImpl;
import com.guy.microservice1.services.TransactionService;
import com.guy.microservice1.services.TransactionServiceImpl;
import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public TransactionService transactionService() {
        return new TransactionServiceImpl();
    }

    @Bean
    public PublisherService publisherService() {
        return Mockito.mock(PublisherServiceRabbitMQImpl.class);
    }

    @Bean
    public Producer producer() {
        return Mockito.mock(RabbitMQProducer.class);
    }

    @Bean
    public AmqpTemplate amqpTemplate() {
        return Mockito.mock(AmqpTemplate.class);
    }
}
