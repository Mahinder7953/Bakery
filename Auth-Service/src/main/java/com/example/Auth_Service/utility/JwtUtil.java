package com.example.Auth_Service.utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtil {

    private final Key key;

    @Value("${jwt.expiration}")
    private long expiration;

    JwtUtil( @Value("${jwt.secret}") String secret){
        this.key= Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String userId,String role) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }
    public String refreshToken() {
        return UUID.randomUUID().toString();
    }

}
