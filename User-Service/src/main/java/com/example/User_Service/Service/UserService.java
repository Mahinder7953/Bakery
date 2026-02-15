package com.example.User_Service.Service;

import com.example.User_Service.Model.User;
import com.example.User_Service.dto.UserDto;
import com.example.User_Service.response.UserReponsepayload;

public interface UserService {

    String registerUser(String name, String email, String password, String phone);

    User getUserById(Long id);

    UserReponsepayload checkUser(UserDto user);

}
