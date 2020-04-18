package com.example.demo.repositories;

import com.example.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepositories extends JpaRepository<UserInfo,Integer> {
}
