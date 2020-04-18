package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.HttpResult;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInfo;
import com.example.demo.repositories.UserRepositories;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;
import com.example.demo.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


        @Autowired
        private UserService userService;
        @Autowired
        private UserInfoService userInfoService;
        @GetMapping
        public List<User> getUserList(){
            return userService.getUserList();
        }
        @PostMapping
        public User addUser(@RequestParam("yonghuming") String yonghuming ,@RequestParam("mima") String mima,@RequestParam("quanxian") String quanxian,@RequestParam("lianxifangshi") String lianxifangshi   ){
            User user=new User();
            user.setYonghuming(yonghuming);
            user.setMima(mima);
            user.setQuanxian(quanxian);
            user.setLianxifangshi(lianxifangshi);
            return userService.addUser(user);
        }
        @PostMapping("/login")
        public String getstring(@RequestParam("code") String code,@RequestParam("yonghuming") String yonghuming) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
            String url="https://api.weixin.qq.com/sns/jscode2session?appid=wx4de1b448d8d7c19f&secret=21024231415c2b29ee323a37e0fb8546&js_code="+code+"&grant_type=authorization_code";
            HttpResult result=HttpUtils.doGet(url);
            JSONObject jsonObject = JSONObject.parseObject(result.getResult());
            String openid = jsonObject.getString("openid");
            String session_key=jsonObject.getString("session_key");
            UserInfo userInfo=new UserInfo();
            userInfo.setOpenid(openid);
            userInfo.setSession_key(session_key);
            userInfo.setYonghuming(yonghuming);
            userInfoService.addUserInfo(userInfo);
            return openid+session_key;
        }

        /* public String getPassword(@RequestParam("yonghuming") String yonghuming,@RequestParam("mima") String mima){
            return userService.getPassword(yonghuming,mima);
        }*/

}