package com.example.demo.service;

import com.example.demo.entity.Sscore;

import java.util.List;

public interface SscoreService {
    public List<Sscore> getSscoreList();
    public Sscore addSscore(Sscore sscore);
    public List<Sscore> getSscore(String yonghuming,String bisaileixing);
}
