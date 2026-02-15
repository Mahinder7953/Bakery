package com.example.Auth_Service.Service;

import com.example.Auth_Service.client.UserClient;
import com.example.Auth_Service.dto.AuthResponse;
import com.example.Auth_Service.dto.RefreshTokenDto;
import com.example.Auth_Service.dto.UserDto;
import com.example.Auth_Service.dto.UserResponseDto;
import com.example.Auth_Service.model.Refresh;
import com.example.Auth_Service.utility.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final String USER_ROLE = "user";
    private UserClient client;
    private RefreshService refreshService;
    private JwtUtil jwtUtil;

    @Override
    public AuthResponse login(UserDto user) {
        UserResponseDto userResponseDto = client.checkUser(user);
        if (userResponseDto!=null){
            //create token
            String accessToken = jwtUtil.generateToken(userResponseDto.getUserId(),USER_ROLE);
            String refreshToken = jwtUtil.refreshToken();

            AuthResponse authResponse = new AuthResponse();
            authResponse.setAccessToken(accessToken);
            authResponse.setRefreshToken(refreshToken);

            refreshService.createRefreshToken(refreshToken,userResponseDto.getId());

            return authResponse;
        }
        return null;

    }

    @Override
    public AuthResponse refreshToken(RefreshTokenDto refreshTokenDto) {
        Refresh refreshToken = refreshService.verifyRefreshToken(refreshTokenDto.getRefreshRoken());
        if (refreshToken.isRevoked()){
            return null;
            // token is revoked
        }
        String newAccessToken = jwtUtil.generateToken(refreshToken.getUserId(),USER_ROLE);

        return new AuthResponse(newAccessToken,refreshToken.getToken());
    }

    @Override
    public void logout(RefreshTokenDto refreshTokenDto) {
        refreshService.revokeRefreshToken(refreshTokenDto.getRefreshRoken());
    }

}
