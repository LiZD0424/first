package com.example.demo.service.impl;

import com.example.demo.entity.Tscore;
import com.example.demo.repositories.TscoreRepositories;
import com.example.demo.service.TscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TscoreServiceImpl implements TscoreService {
    @Autowired
    private TscoreRepositories tscoreRepositories;

    @Override
    public List<Tscore> getTscoreList() {
        return tscoreRepositories.findAll();
    }

    @Override
    public Tscore addTscore(Tscore tscore) {
        return tscoreRepositories.save(tscore);
    }

    @Override
    public List<Tscore> getSscore(String yonghuming) {
        List<Tscore> k=tscoreRepositories.findByCansaizhe1(yonghuming);
        List<Tscore> m=tscoreRepositories.findByCansaizhe2(yonghuming);
        k.addAll(m);
        if(!k.isEmpty())
            return k;
        else
            return null ;
    }
}
