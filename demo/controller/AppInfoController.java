package com.example.demo.controller;

import com.example.demo.entity.AppInfo;
import com.example.demo.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("AppInfo")
@RestController
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;
    @GetMapping
    public List<AppInfo> getAppInfoList(){
        return appInfoService.getAppInfoList();
    }
    @PostMapping
    public AppInfo addAppInfo(@RequestParam("bisaileixing") String bisaileixing,@RequestParam("shenqingren") String shenqingren,@RequestParam("biangengqianmingcheng")String biangengqianmingcheng,@RequestParam("biangenghoumingcheng")String biangenghoumingcheng,@RequestParam("biangengliyou")String biangengliyou){
    AppInfo appInfo=new AppInfo();
    appInfo.setShenqingren(shenqingren);
    appInfo.setBiangenghoumingcheng(biangenghoumingcheng);
    appInfo.setBiangengqianmingcheng(biangengqianmingcheng);
    appInfo.setBiangengliyou(biangengliyou);
    appInfo.setBisaileixing(bisaileixing);
    appInfo.setShenqingzhuangtai("1");
    return appInfoService.addAppInfo(appInfo);
    }
    @PostMapping("/change/y")
    public int change(@RequestParam("id")int id){
        appInfoService.refuse(id);
        return  appInfoService.change(id);
    }
    @PostMapping("/change/n")
    public void refuse(@RequestParam("id")int id){
        appInfoService.refuse(id);
    }
}
