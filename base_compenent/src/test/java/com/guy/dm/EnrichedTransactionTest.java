package com.guy.dm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EnrichedTransactionTest {

    private static EnrichedTransaction enrichedTransaction1;
    private static String country = "USA";
    private static double exchangeRate = 3.68;
    private static long time = System.currentTimeMillis();
    private static double amount = 100;
    private static Currency currency = Currency.NIS;

    @BeforeClass
    public static void setUp() {
        enrichedTransaction1 = new EnrichedTransaction(amount, currency, time, country, exchangeRate);
    }

    @Test
    public void testConstructors() {
        EnrichedTransaction enrichedTransaction = new EnrichedTransaction(new TimeTransaction(amount, currency, time));
        Assert.assertNull(enrichedTransaction.getCountry());
        Assert.assertEquals(enrichedTransaction.getExchangeRate(), 0.0, 0.0);

        enrichedTransaction.setCountry(country);
        Assert.assertEquals(enrichedTransaction.getCountry(), country);
    }

    @Test
    public void testGetCountry() {
        Assert.assertEquals(enrichedTransaction1.getCountry(), country);
    }

    @Test
    public void testSetCountry() {
        EnrichedTransaction enrichedTransaction2 = new EnrichedTransaction(enrichedTransaction1);
        enrichedTransaction2.setCountry("Israel");
        Assert.assertNotEquals(enrichedTransaction1.getCountry(), enrichedTransaction2.getCountry());
    }

    @Test
    public void getExchangeRate() {
        Assert.assertEquals(enrichedTransaction1.getExchangeRate(), exchangeRate, 0);
    }

    @Test
    public void testSetExchangeRate() {
        EnrichedTransaction enrichedTransaction2 = new EnrichedTransaction(enrichedTransaction1);
        enrichedTransaction2.setExchangeRate(3.4);
        Assert.assertNotEquals(enrichedTransaction1.getExchangeRate(), enrichedTransaction2.getExchangeRate());
    }

    @Test
    public void testEqualsAndHashCode() {
        EnrichedTransaction enrichedTransaction2 = new EnrichedTransaction(enrichedTransaction1);
        Assert.assertEquals(enrichedTransaction1, enrichedTransaction2);
        Assert.assertEquals(enrichedTransaction1.hashCode(), enrichedTransaction2.hashCode());

        enrichedTransaction2.setCountry("Israel");
        Assert.assertNotEquals(enrichedTransaction1, enrichedTransaction2);
        Assert.assertNotEquals(enrichedTransaction1.hashCode(), enrichedTransaction2.hashCode());

        enrichedTransaction2 = new EnrichedTransaction(enrichedTransaction1);
        enrichedTransaction2.setExchangeRate(3.2);
        Assert.assertNotEquals(enrichedTransaction1, enrichedTransaction2);
        Assert.assertNotEquals(enrichedTransaction1.hashCode(), enrichedTransaction2.hashCode());
    }


    @Test
    public void testToString() {
        String enrichedTransaction1String = "EnrichedTransaction{" +
            "currency=" + enrichedTransaction1.getCurrency() +
                    ", amount=" + enrichedTransaction1.getAmount() +
                    ", time=" + enrichedTransaction1.getTime() +
                    ", country=" + enrichedTransaction1.getCountry() +
                    ", exchangeRate=" + enrichedTransaction1.getExchangeRate() +
                    "}";
        Assert.assertEquals(enrichedTransaction1.toString(), enrichedTransaction1String);
    }

}