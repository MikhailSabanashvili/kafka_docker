package com.example.producerservice.controller;

import com.example.producerservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageManager {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping
    private String sendMessage(@RequestBody User user){
        kafkaTemplate.send("transaction-1", user);
        return "OK";
    }

}
