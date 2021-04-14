package com.fudan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class CustomerController {

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> msg){
        log.info("receive: {}", msg.getPayload());
    }
}
