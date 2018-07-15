package com.guy.microservice1.services;

import com.guy.dm.BaseTransaction;
import com.guy.dm.TimeTransaction;

public interface TransactionService {

    TimeTransaction enrichTransaction(BaseTransaction transaction);

    Boolean sendTransaction(TimeTransaction transaction);

}
