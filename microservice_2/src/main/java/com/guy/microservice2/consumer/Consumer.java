package com.guy.microservice2.consumer;

public interface Consumer <T extends Object>{

    void recievedMessage(T t);

}
