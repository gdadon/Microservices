package com.guy.dm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class BaseTransaction implements Serializable {

    private Currency currency;
    private double amount;

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public BaseTransaction(){}

    @JsonCreator
    public BaseTransaction(@JsonProperty(value = "amount", required = true)double amount,
                           @JsonProperty(value = "currency", required = true) Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BaseTransaction(BaseTransaction transaction) {
        this.amount = transaction.amount;
        this.currency = transaction.currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseTransaction)) return false;
        BaseTransaction that = (BaseTransaction) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 &&
                getCurrency() == that.getCurrency();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCurrency(), getAmount());
    }

    @Override
    public String toString() {
        return "BaseTransaction{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
