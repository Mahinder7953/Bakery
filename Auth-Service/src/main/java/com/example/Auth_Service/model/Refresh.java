package com.example.Auth_Service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "refresh_Token_data")
public class Refresh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String token;
    private LocalDateTime exp;
    private LocalDateTime createdAt;
    private boolean revoked = false;
}
