package com.example.User_Service.Service;

import org.springframework.stereotype.Service;

import com.example.User_Service.Model.User;
import com.example.User_Service.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;

    @Override
    public String registerUser(String name, String email, String password, String phone) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
