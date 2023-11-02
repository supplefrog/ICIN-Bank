package com.backend.service;

import com.backend.entity.User;
import com.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser (Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
