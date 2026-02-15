package com.example.Auth_Service.Service;

import com.example.Auth_Service.model.Refresh;

public interface RefreshService {
    public void createRefreshToken(String refreshToken,String userId);

    public Refresh verifyRefreshToken(String refreshToken);

    public void revokeRefreshToken(String refreshToken);

    public void revokeAllUserTokens(Long userId);
}
