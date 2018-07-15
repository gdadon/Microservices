package com.guy.microservice2.repository;

import com.guy.microservice2.dm.MongoEnrichedTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMongoRepository extends MongoRepository<MongoEnrichedTransaction, Long> {

}
