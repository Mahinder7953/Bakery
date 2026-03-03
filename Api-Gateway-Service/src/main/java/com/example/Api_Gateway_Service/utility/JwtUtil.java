package com.example.Api_Gateway_Service.utility;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.Keys;

@Component
@Slf4j
public class JwtUtil {
    private final Key key;

    public JwtUtil(@Value("${jwt.secret}") String secret){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Claims validateToken(String token){
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (ExpiredJwtException e){
            log.error("JWT Expired");
            throw new RuntimeException("Token expired");

        } catch (UnsupportedJwtException ex) {
            throw new RuntimeException("Unsupported token");

        } catch (MalformedJwtException ex) {
            throw new RuntimeException("Invalid token");

        } catch (SignatureException ex) {
            throw new RuntimeException("Invalid signature");

        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Token missing");
        }
    }
}
