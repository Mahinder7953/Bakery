package com.example.User_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User_Service.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
