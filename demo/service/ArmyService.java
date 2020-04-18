package com.example.demo.service;

import com.example.demo.entity.Army;

import java.util.List;

public interface ArmyService {
    public List<Army> getArmyList();
    public List<Army> getArmyListByDuiwumingcheng(String duiwumingcheng);
    public List<Army> getArmyListByDuizhang(String duizhang);
    public Army addArmy(Army army);
    public int updata(String yonghuming,String duiwumingcheng);
    public void updataDuiyuan(String shenqingren,String duizhang);
    public void updata_1(String yonghuming,String duizhang,String i);
    public void updataduiyuan(String yonghuming,String duizhang);
}
