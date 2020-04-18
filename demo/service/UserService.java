package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    public List<User> getUserList();
    public User addUser(User user);
    public String getPassword(String yonghuming,String mima);
}
