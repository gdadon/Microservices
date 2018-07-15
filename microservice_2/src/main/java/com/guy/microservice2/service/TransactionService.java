package com.guy.microservice2.service;

import com.guy.dm.EnrichedTransaction;
import com.guy.dm.TimeTransaction;

public interface TransactionService {

    EnrichedTransaction enrichTransaction(TimeTransaction transaction);

    void saveTransaction(EnrichedTransaction transaction);

}
