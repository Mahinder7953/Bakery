package com.example.Api_Gateway_Service.filter;

import com.example.Api_Gateway_Service.utility.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Slf4j
public class JwtAuthenticationFilter implements GlobalFilter {

    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().toString();

        //public endpoints
        if (path.contains("/auth")){
            return chain.filter(exchange);
        }
        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        log.info("authHeader : {}",authHeader);
        if (authHeader==null || !authHeader.contains("Bearer ")){

            return unauthorized(exchange);
        }
        String token = authHeader.substring(7);
        log.info("Token : {}",token);
        try{
            jwtUtil.validateToken(token);
        }
        catch (Exception e){
            return unauthorized(exchange);
        }

        return chain.filter(exchange);
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
         exchange.getResponse()
                .setStatusCode(HttpStatus.UNAUTHORIZED);
         return exchange.getResponse().setComplete();
    }

}
