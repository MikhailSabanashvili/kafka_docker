package com.example.consumerservice.controller;


import com.example.consumerservice.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ConsumerController {

    public void listener(@Payload User user, ConsumerRecord<String, User> consumerRecord){
        log.info("Получили: {}", user.toString());
        log.info(consumerRecord.toString());
    }

}
