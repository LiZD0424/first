package com.example.demo.repositories;

import com.example.demo.entity.Tscore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TscoreRepositories extends JpaRepository<Tscore,Integer> {
    public List<Tscore> findByCansaizhe1(String cansaizhe1);
    public List<Tscore>findByCansaizhe2(String cansaizhe2);
}
