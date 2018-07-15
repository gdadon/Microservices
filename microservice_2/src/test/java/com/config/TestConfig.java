package com.config;

import com.guy.microservice2.repository.TransactionMongoRepository;
import com.guy.microservice2.service.TransactionService;
import com.guy.microservice2.service.TransactionServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestConfig {

    @Bean
    TransactionService transactionService() {
        return new TransactionServiceImpl();
    }

    @Bean
    TransactionMongoRepository transactionMongoRepository() {
        return Mockito.mock(TransactionMongoRepository.class);
    }
}
