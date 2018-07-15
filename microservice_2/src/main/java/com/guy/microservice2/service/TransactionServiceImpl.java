package com.guy.microservice2.service;

import com.guy.dm.EnrichedTransaction;
import com.guy.dm.TimeTransaction;
import com.guy.microservice2.dm.MongoEnrichedTransaction;
import com.guy.microservice2.repository.TransactionMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionMongoRepository transactionRepository;

    @Override
    public EnrichedTransaction enrichTransaction(TimeTransaction transaction) {
        System.out.println("in enrichTransaction()... start's enriching");
        EnrichedTransaction enrichedTransaction = new EnrichedTransaction(transaction);
        enrichedTransaction.setCountry("Israel");
        enrichedTransaction.setExchangeRate(3.68);
        return enrichedTransaction;
    }

    @Override
    public void saveTransaction(EnrichedTransaction transaction) {
        MongoEnrichedTransaction mongoEnrichedTransaction = new MongoEnrichedTransaction(transaction);
        transactionRepository.save(mongoEnrichedTransaction);
    }
}
