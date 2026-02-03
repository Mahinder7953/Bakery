package com.example.User_Service.Service;

import com.example.User_Service.Model.User;

public interface UserService {

    String registerUser(String name, String email, String password, String phone);

    User getUserById(Long id);

}
