package com.guy.microservice1.controllers;

import com.guy.dm.BaseTransaction;
import com.guy.dm.TimeTransaction;
import com.guy.microservice1.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/processTransaction", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus processTransaction(@RequestBody BaseTransaction transaction) {

        TimeTransaction enrichedTransaction = transactionService.enrichTransaction(transaction);
        transactionService.sendTransaction(enrichedTransaction);

        return HttpStatus.OK;
    }

}
