package com.guy.microservice2.consumer;

import com.guy.dm.EnrichedTransaction;
import com.guy.dm.TimeTransaction;
import com.guy.microservice2.service.TransactionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerImpl implements Consumer <TimeTransaction> {

    @Autowired
    TransactionService transactionService;

	@RabbitListener(queues="${rabbitmq.queue}", containerFactory="connectionFactory")
    public void recievedMessage(TimeTransaction transaction) {
        EnrichedTransaction enrichedTransaction = transactionService.enrichTransaction(transaction);
        transactionService.saveTransaction(enrichedTransaction);
    }

}