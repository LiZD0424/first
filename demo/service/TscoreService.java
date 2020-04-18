package com.example.demo.service;

import com.example.demo.entity.Tscore;

import java.util.List;

public interface TscoreService {
    public List<Tscore> getTscoreList();
    public Tscore addTscore(Tscore tscore);
    public List<Tscore> getSscore(String yonghuming);
}
