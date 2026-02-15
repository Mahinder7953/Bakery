package com.example.Auth_Service.Service;

import com.example.Auth_Service.Repository.RefreshRepository;
import com.example.Auth_Service.model.Refresh;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RefreshServiceImpl implements RefreshService{

    private RefreshRepository refreshRepository;

    @Override
    public void createRefreshToken(String refreshToken,String userId) {
        Refresh refresh = new Refresh();
        refresh.setToken(refreshToken);
        refresh.setUserId(userId);
        refresh.setCreatedAt(LocalDateTime.now());
        refresh.setExp(LocalDateTime.now().plus(Duration.ofDays(10)));
        refreshRepository.save(refresh);
    }

    @Override
    public Refresh verifyRefreshToken(String token) {
        Refresh refreshToken = refreshRepository.findByToken(token);
        if (refreshToken==null){
            //Throw Exception - Invalid refresh token
        }
        if (refreshToken.getExp().isBefore(LocalDateTime.now())){
            refreshRepository.delete(refreshToken);
            //throw Exception - token expired
        }
        return refreshToken;
    }

    @Override
    public void revokeRefreshToken(String token) {
        Refresh refreshToken = verifyRefreshToken(token);
        refreshToken.setRevoked(true);
        refreshRepository.save(refreshToken);
    }

    @Override
    public void revokeAllUserTokens(Long userId) {
        List<Refresh> tokens = refreshRepository.findByUserId(userId.toString());
        tokens.forEach(t -> t.setRevoked(true));
        refreshRepository.saveAll(tokens);
    }

}
