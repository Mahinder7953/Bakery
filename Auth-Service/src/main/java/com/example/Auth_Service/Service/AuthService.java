package com.example.Auth_Service.Service;

import com.example.Auth_Service.dto.AuthResponse;
import com.example.Auth_Service.dto.RefreshTokenDto;
import com.example.Auth_Service.dto.UserDto;

public interface AuthService {
    AuthResponse login(UserDto user);

    AuthResponse refreshToken(RefreshTokenDto refreshTokenDto);

    void logout(RefreshTokenDto refreshTokenDto);

}
