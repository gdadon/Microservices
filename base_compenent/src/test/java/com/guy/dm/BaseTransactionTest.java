package com.guy.dm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class BaseTransactionTest {

    private static BaseTransaction baseTransaction1;
    private static double amount1 = 100;
    private static Currency currency1 = Currency.NIS;

    @BeforeClass
    public static void setUp() {
        baseTransaction1 = new BaseTransaction(amount1, currency1);
    }

    @Test
    public void testGetCurrency() {
        Assert.assertEquals(baseTransaction1.getCurrency(), currency1);
    }

    @Test
    public void testGetAmount() {
        Assert.assertEquals(baseTransaction1.getAmount(), amount1, 0);
    }

    @Test
    public void testEquals() {
        BaseTransaction baseTransaction2 = new BaseTransaction(baseTransaction1);
        Assert.assertEquals(baseTransaction1, baseTransaction2);

        baseTransaction2 = new BaseTransaction(150, currency1);
        Assert.assertNotEquals(baseTransaction1, baseTransaction2);
    }

    @Test
    public void testHashCode() {
        BaseTransaction baseTransaction2 = new BaseTransaction(amount1, currency1);
        Assert.assertEquals(baseTransaction1.hashCode(), baseTransaction2.hashCode());

        baseTransaction2 = new BaseTransaction(150, currency1);
        Assert.assertNotEquals(baseTransaction1.hashCode(), baseTransaction2.hashCode());

        baseTransaction2 = new BaseTransaction(amount1, Currency.USD);
        Assert.assertNotEquals(baseTransaction1.hashCode(), baseTransaction2.hashCode());

        baseTransaction2 = new BaseTransaction(130, Currency.GPB);
        Assert.assertNotEquals(baseTransaction1.hashCode(), baseTransaction2.hashCode());
    }

    @Test
    public void testToString() {
        String transaction1String = "BaseTransaction{" +
                "currency=" + currency1 +
                ", amount=" + amount1 +
                "}";
        Assert.assertEquals(baseTransaction1.toString(), transaction1String);
    }
}