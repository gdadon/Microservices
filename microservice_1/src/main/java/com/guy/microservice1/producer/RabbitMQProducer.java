package com.guy.microservice1.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer extends Producer {

    private static Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public Boolean produce(Object object){
        try {
            amqpTemplate.convertAndSend(exchange, routingkey, object);
            logger.debug("Successfully send msg = " + object);
            return Boolean.TRUE;
        }catch (AmqpException e) {
            logger.error("Failed to publish message '" + object + "'", e);
            return Boolean.FALSE;
        }
    }
}
