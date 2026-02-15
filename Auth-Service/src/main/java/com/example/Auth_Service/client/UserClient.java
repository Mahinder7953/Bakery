package com.example.Auth_Service.client;

import com.example.Auth_Service.dto.UserDto;
import com.example.Auth_Service.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "User-Service")
public interface UserClient {

    @PostMapping("/user/verify")
    public UserResponseDto checkUser(@RequestBody UserDto user);
}
