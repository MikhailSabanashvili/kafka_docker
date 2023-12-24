package com.example.consumerservice.controller;


import com.example.consumerservice.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    public void listener(@Payload User user, ConsumerRecord<String, User> consumerRecord){
        System.out.println("Получили: " + user);
    }

}
