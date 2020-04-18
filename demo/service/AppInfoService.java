package com.example.demo.service;

import com.example.demo.entity.AppInfo;

import java.util.List;

public interface AppInfoService {
    public List<AppInfo> getAppInfoList();
    public AppInfo addAppInfo(AppInfo appInfo);
    public int change(int id);
    public void refuse(int id);
}
