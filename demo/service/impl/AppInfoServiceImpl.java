package com.example.demo.service.impl;

import com.example.demo.entity.AppInfo;
import com.example.demo.repositories.AppInfoRepositories;
import com.example.demo.repositories.MatchRepositories;
import com.example.demo.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoRepositories appInfoRepositories;
    @Autowired
    private MatchRepositories matchRepositories;

    @Override
    public List<AppInfo> getAppInfoList() {
        return appInfoRepositories.findByShenqingzhuangtai("1");
    }

    @Override
    public AppInfo addAppInfo(AppInfo appInfo) {
        return appInfoRepositories.save(appInfo);
    }

    @Override
    public int change(int id) {
        String mingcheng1=appInfoRepositories.findMingcheng1(id);
        String mingcheng2=appInfoRepositories.findMingcheng2(id);
        String bisaileixing=appInfoRepositories.findBisaileixing(id);
        String shenqingren=appInfoRepositories.findShenqingren(id);
        if(matchRepositories.findCaipan(mingcheng2,"1",bisaileixing).equals("-1")){
            matchRepositories.updateCaipan(shenqingren,mingcheng2,"1",bisaileixing);
            matchRepositories.updateCaipan("-1",mingcheng1,"1",bisaileixing);
            return 1;
        }else
            return 0;
    }

    @Override
    public void refuse(int id) {
        appInfoRepositories.refuse("2",id);
    }
}
