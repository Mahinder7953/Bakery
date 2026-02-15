package com.example.Auth_Service.Repository;

import com.example.Auth_Service.model.Refresh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefreshRepository extends JpaRepository<Refresh,Long> {
    Refresh findByToken(String token);

    List<Refresh> findByUserId(String userId);
}
