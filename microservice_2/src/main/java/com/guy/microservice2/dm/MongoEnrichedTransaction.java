package com.guy.microservice2.dm;

import com.guy.dm.EnrichedTransaction;
import org.springframework.data.annotation.Id;

public class MongoEnrichedTransaction extends EnrichedTransaction{

    @Id
    private String id;

    public MongoEnrichedTransaction(){}

    public MongoEnrichedTransaction(EnrichedTransaction transaction){
        super(transaction);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
