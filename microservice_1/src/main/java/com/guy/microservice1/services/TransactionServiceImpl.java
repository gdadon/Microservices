package com.guy.microservice1.services;

import com.guy.dm.BaseTransaction;
import com.guy.dm.TimeTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private PublisherService publisherService;

    private static Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Override
    public TimeTransaction enrichTransaction(BaseTransaction transaction) {
        long time = System.currentTimeMillis();
        logger.debug("transaction received at " + time);
        return new TimeTransaction(transaction.getAmount(), transaction.getCurrency(), time);
    }

    @Override
    public Boolean sendTransaction(TimeTransaction transaction) {
        logger.debug("Send transaction: " + transaction);
        Boolean isSendSuccess = publisherService.publish(transaction);
        if(!isSendSuccess) {
            logger.error("Failed to send transaction");
            return Boolean.FALSE;
        }
        logger.debug("Successfully sent transaction");
        return Boolean.TRUE;
    }
}
