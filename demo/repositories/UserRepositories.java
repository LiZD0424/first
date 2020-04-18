package com.example.demo.repositories;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepositories extends JpaRepository<User,Integer> {
    public String findMimaByYonghuming(String yonghuming);
}

