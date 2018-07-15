package com.guy.dm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TimeTransactionTest {

    private static TimeTransaction timeTransaction1;
    private static long time = 0;
    private static double amount1 = 100;
    private static Currency currency1 = Currency.NIS;

    @BeforeClass
    public static void setUp() {
        timeTransaction1 = new TimeTransaction(amount1, currency1, time);
    }

    @Test
    public void testGetTime() {
        Assert.assertEquals(timeTransaction1.getTime(), time);
    }

    @Test
    public void testSetTime() {
        time = System.currentTimeMillis();
        timeTransaction1.setTime(time);
        Assert.assertEquals(timeTransaction1.getTime(), time);
    }

    @Test
    public void testEquals() {
        TimeTransaction timeTransaction2 = new TimeTransaction(timeTransaction1);
        Assert.assertEquals(timeTransaction1, timeTransaction2);

        timeTransaction2.setTime(System.currentTimeMillis());
        Assert.assertNotEquals(timeTransaction1, timeTransaction2);
    }

    @Test
    public void testHashCode() {
        TimeTransaction timeTransaction2 = new TimeTransaction(timeTransaction1);
        Assert.assertEquals(timeTransaction1.hashCode(), timeTransaction2.hashCode());

        timeTransaction2.setTime(System.currentTimeMillis());
        Assert.assertNotEquals(timeTransaction1.hashCode(), timeTransaction2.hashCode());
    }

    @Test
    public void testToString() {
        String transaction1String = "TimeTransaction{" +
                "currency=" + timeTransaction1.getCurrency() +
                ", amount=" + timeTransaction1.getAmount() +
                ", time=" + time +
                "}";
        Assert.assertEquals(timeTransaction1.toString(), transaction1String);
    }
}