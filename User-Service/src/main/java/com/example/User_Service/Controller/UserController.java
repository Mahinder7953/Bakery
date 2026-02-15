package com.example.User_Service.Controller;

import com.example.User_Service.dto.UserDto;
import com.example.User_Service.response.UserReponsepayload;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_Service.Model.User;
import com.example.User_Service.Service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;
    
    @PostMapping("/register")
    public String register(@RequestBody User entity) {
        return userService.registerUser(entity.getName(), entity.getEmail(), entity.getPassword(), entity.getPhone());
    }
    
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user/verify")
    public UserReponsepayload checkUser(@RequestBody UserDto user) {
        return userService.checkUser(user);
    }
    
}
