package com.guy.dm;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TimeTransaction extends BaseTransaction {

    private long time;

    public TimeTransaction() {

    }

    @JsonCreator
    public TimeTransaction(@JsonProperty(value = "amount", required = true)double amount,
                           @JsonProperty(value = "currency", required = true) Currency currency,
                           @JsonProperty(value = "time", required = true) long time) {
        super(amount, currency);
        this.time = time;
    }

    public TimeTransaction(TimeTransaction transaction) {
        super(transaction);
        this.time = transaction.time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeTransaction)) return false;
        if (!super.equals(o)) return false;
        TimeTransaction that = (TimeTransaction) o;
        return time == that.time;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), time);
    }

    @Override
    public String toString() {
        return "TimeTransaction{" +
                "currency=" + getCurrency() +
                ", amount=" + getAmount() +
                ", time=" + time +
                "}";
    }
}