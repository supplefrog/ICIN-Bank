package com.backend.controller;

import com.backend.entity.User;
import com.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/userentity")
    public List<User> getAll(){
        return userService.findAllUsers();
    }

    @PostMapping("/admin/userentity/{id}")
    public User searchUserById(@PathVariable Long id) {
        return userService.findUser(id);
    }
}
