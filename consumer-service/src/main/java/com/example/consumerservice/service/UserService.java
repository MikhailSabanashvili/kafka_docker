package com.example.consumerservice.service;

import com.example.consumerservice.entity.User;
import com.example.consumerservice.model.UserDto;
import com.example.consumerservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        userRepository.save(user);
    }
}
