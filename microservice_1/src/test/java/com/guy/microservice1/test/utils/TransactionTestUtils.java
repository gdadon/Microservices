package com.guy.microservice1.test.utils;

import com.guy.dm.BaseTransaction;
import com.guy.dm.Currency;
import com.guy.dm.TimeTransaction;

public class TransactionTestUtils {

    private static double defaultAmount = 100;
    private static Currency defualtCurrency = Currency.NIS;

    public static BaseTransaction getBaseTransaction(){
        return new BaseTransaction(defaultAmount, defualtCurrency);
    }

    public static TimeTransaction getTimeTrnasaction(){
        return new TimeTransaction(defaultAmount, defualtCurrency, System.currentTimeMillis());
    }

}
