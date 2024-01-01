package com.example.consumerservice.controller;


import com.example.consumerservice.model.UserDto;
import com.example.consumerservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsumerController {
    private final UserService userService;

    @KafkaListener(topics = "transaction-1")
    public void listener(@Payload String userInfo, ConsumerRecord<String, UserDto> consumerRecord){
        UserDto userDto = createUser(userInfo);
        userService.saveUser(userDto);
    }

    private UserDto createUser(String userInfo) {
        String[] arr = userInfo.split("=");
        String id = arr[1].split(",")[0];
        String name = arr[2].substring(0, arr[2].length() - 1);

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        return userDto;
    }

}
