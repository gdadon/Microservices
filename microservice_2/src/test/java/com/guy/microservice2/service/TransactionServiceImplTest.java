package com.guy.microservice2.service;

import com.config.TestConfig;
import com.guy.dm.Currency;
import com.guy.dm.EnrichedTransaction;
import com.guy.dm.TimeTransaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by gdadon on 7/15/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class TransactionServiceImplTest {

    private double amount;
    private Currency currency;
    private long time;

    @Autowired
    TransactionService transactionService;

    @Test
    public void testEnrichTransaction() throws Exception {
        time = System.currentTimeMillis();
        TimeTransaction timeTransaction = new TimeTransaction(amount, currency, time);
        EnrichedTransaction enrichedTransaction = transactionService.enrichTransaction(timeTransaction);
        Assert.assertNotNull(enrichedTransaction);
        Assert.assertNotNull(enrichedTransaction.getCountry());
        Assert.assertEquals(enrichedTransaction.getCountry(), "Israel");
        Assert.assertNotNull(enrichedTransaction.getExchangeRate());
        Assert.assertEquals(enrichedTransaction.getExchangeRate(), 3.68, 0);

    }

}