package com.guy.dm;

import java.util.Objects;

public class EnrichedTransaction extends TimeTransaction {

    private String id;
    private String country;
    private double exchangeRate;

    public EnrichedTransaction(){
    }

    public EnrichedTransaction(TimeTransaction transaction) {
        super(transaction);
    }

    public EnrichedTransaction(double amount, Currency currency, long time, String country, double exchangeRate) {
        super(amount, currency, time);
        this.country = country;
        this.exchangeRate = exchangeRate;
    }

    public EnrichedTransaction(EnrichedTransaction transaction) {
        super(transaction);
        this.country = transaction.country;
        this.exchangeRate = transaction.exchangeRate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnrichedTransaction)) return false;
        if (!super.equals(o)) return false;
        EnrichedTransaction that = (EnrichedTransaction) o;
        return Double.compare(that.getExchangeRate(), getExchangeRate()) == 0 &&
                Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getCountry(), getExchangeRate());
    }

    @Override
    public String toString() {
        return "EnrichedTransaction{" +
                "currency=" + getCurrency() +
                ", amount=" + getAmount() +
                ", time=" + getTime() +
                ", country=" + country +
                ", exchangeRate=" + exchangeRate +
                "}";
    }
}
