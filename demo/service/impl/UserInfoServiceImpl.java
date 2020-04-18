package com.example.demo.service.impl;

import com.example.demo.entity.UserInfo;
import com.example.demo.repositories.UserInfoRepositories;
import com.example.demo.repositories.UserRepositories;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepositories userInfoRepositories;

    @Override
    public List<UserInfo> getUserInfoList() {
        return userInfoRepositories.findAll();
    }

    @Override
    public UserInfo addUserInfo(UserInfo userInfo) {
        return userInfoRepositories.save(userInfo);
    }
}
