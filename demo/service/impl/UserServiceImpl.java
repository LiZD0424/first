package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepositories;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositories userRepositories;
    @Override
    public List<User> getUserList() {
        return userRepositories.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepositories.save(user);
    }

    @Override
    public String getPassword(String yonghuming,String miam){
        return userRepositories.findMimaByYonghuming(yonghuming);
        //@Modifying
        //@Query("update User u set u.firstname = ?1 where u.lastname = ?2")
        //int setFixedFirstnameFor(String firstname, String lastname);
    }
}
