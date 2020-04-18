package com.example.demo.service.impl;

import com.example.demo.entity.Sscore;
import com.example.demo.repositories.SscoreRepositories;
import com.example.demo.service.SscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SscoreServiceImpl implements SscoreService {
    @Autowired
    private SscoreRepositories sscoreRepositories;

    @Override
    public List<Sscore> getSscoreList() {
        return sscoreRepositories.findAll();
    }

    @Override
    public Sscore addSscore(Sscore sscore) {
        return sscoreRepositories.save(sscore);
    }

    @Override
    public List<Sscore> getSscore(String yonghuming,String bisaileixing) {
        List<Sscore> k=sscoreRepositories.findByCansaizhe1AndBisaileixing(yonghuming,bisaileixing);
        List<Sscore> m=sscoreRepositories.findByCansaizhe2AndBisaileixing(yonghuming,bisaileixing);
        k.addAll(m);
        if(!k.isEmpty())
            return k;
        else
            return null ;
    }

}
