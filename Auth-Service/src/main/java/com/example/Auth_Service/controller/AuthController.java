package com.example.Auth_Service.controller;

import com.example.Auth_Service.Service.AuthService;
import com.example.Auth_Service.dto.AuthResponse;
import com.example.Auth_Service.dto.RefreshTokenDto;
import com.example.Auth_Service.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserDto auth){
        return authService.login(auth);
    }

    @PostMapping("/refresh")
    public AuthResponse refresh(@RequestBody RefreshTokenDto refreshTokenDto){
        return authService.refreshToken(refreshTokenDto);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody RefreshTokenDto refreshTokenDto){
        authService.logout(refreshTokenDto);
    }

}
