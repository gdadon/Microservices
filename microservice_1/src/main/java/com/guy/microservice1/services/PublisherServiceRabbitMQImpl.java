package com.guy.microservice1.services;

import com.guy.microservice1.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("publisherServiceRabbitMQImpl")
public class PublisherServiceRabbitMQImpl implements PublisherService{

    @Autowired
    private Producer producer;

    public Boolean publish(Object object){
        return producer.produce(object);
    }

}
