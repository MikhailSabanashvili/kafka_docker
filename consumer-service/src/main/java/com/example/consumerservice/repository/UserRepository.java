package com.example.consumerservice.repository;

import com.example.consumerservice.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
