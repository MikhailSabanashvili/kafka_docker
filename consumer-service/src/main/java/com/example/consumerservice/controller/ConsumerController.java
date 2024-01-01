package com.example.consumerservice.controller;


import com.example.consumerservice.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    @KafkaListener(topics = "transaction-1")
    public void listener(@Payload String userInfo, ConsumerRecord<String, User> consumerRecord){
        User user = createUser(userInfo);
        System.out.println(user);
    }

    private User createUser(String userInfo) {
        String[] arr = userInfo.split("=");
        String id = arr[1].split(",")[0];
        String name = arr[2].substring(0, arr[2].length() - 1);

        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

}
