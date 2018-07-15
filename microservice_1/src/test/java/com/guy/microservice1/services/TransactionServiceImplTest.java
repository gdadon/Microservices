package com.guy.microservice1.services;

import com.guy.dm.BaseTransaction;
import com.guy.dm.TimeTransaction;
import com.guy.microservice1.config.TestConfig;
import com.guy.microservice1.test.utils.TransactionTestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class TransactionServiceImplTest {

    @Autowired
    TransactionService transactionService;

    @Autowired
    PublisherService publisherService;

    @Test
    public void testEnrichTransaction() {
        Long startTime = System.currentTimeMillis() - 100;
        BaseTransaction baseTransaction = TransactionTestUtils.getBaseTransaction();
        TimeTransaction enrichTransaction = transactionService.enrichTransaction(baseTransaction);
        Assert.assertTrue(startTime < enrichTransaction.getTime());
    }

    @Test
    public void testSendTransaction_success() {
        Mockito.when(publisherService.publish(Mockito.any())).thenReturn(Boolean.TRUE);

        TimeTransaction transaction = TransactionTestUtils.getTimeTrnasaction();
        Boolean isSendSuccess = transactionService.sendTransaction(transaction);
        Assert.assertNotNull(isSendSuccess);
        Assert.assertTrue("Assert failed - should have success send transaction", isSendSuccess);
    }

    @Test
    public void testSendTransaction_failure() {
        Mockito.when(publisherService.publish(Mockito.any())).thenReturn(Boolean.FALSE);

        TimeTransaction transaction = TransactionTestUtils.getTimeTrnasaction();
        Boolean isSendSuccess = transactionService.sendTransaction(transaction);
        Assert.assertNotNull(isSendSuccess);
        Assert.assertFalse("Assert failed - should have failed send transaction", isSendSuccess);
    }

//    @Test
//    public void testSendTransaction_exception() {
//
//    }

}