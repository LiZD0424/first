package com.example.demo.service.impl;

import com.example.demo.entity.Army;
import com.example.demo.repositories.ArmyRepositories;
import com.example.demo.service.ArmyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArmyServiceImpl implements ArmyService {
    @Autowired
    private ArmyRepositories armyRepositories;

    @Override
    public List<Army> getArmyList() {
        return armyRepositories.findAll();
    }

    @Override
    public List<Army> getArmyListByDuiwumingcheng(String duiwumingcheng) {
        return armyRepositories.findByDuiwumingcheng(duiwumingcheng);
    }

    @Override
    public Army addArmy(Army army) {
        return armyRepositories.save(army);
    }

    @Override
    @Transactional
    public int updata(String yonghuming, String duiwumingcheng) {
       if(armyRepositories.findShenqingren1ByDuiwumingcheng(duiwumingcheng)==null){
           return -1;
        }else if(armyRepositories.findShenqingren2ByDuiwumingcheng(duiwumingcheng).equals("-1")){
            armyRepositories.updateTwo(yonghuming,duiwumingcheng);
            return 2;
        }else if(armyRepositories.findShenqingren3ByDuiwumingcheng(duiwumingcheng).equals("-1")){
            armyRepositories.updateThree(yonghuming,duiwumingcheng);
            return 3;
        }else if(armyRepositories.findShenqingren1ByDuiwumingcheng(duiwumingcheng).equals("-1")){
           armyRepositories.updateOne(yonghuming,duiwumingcheng);
           return 1;
       } else
           return 0;
    }

    @Override
    public List<Army> getArmyListByDuizhang(String duizhang) {
        return armyRepositories.findByDuizhang(duizhang);
    }

    @Override
    @Transactional
    public void updata_1(String yonghuming, String duizhang,String i) {
        if(i.equals("1"))
            armyRepositories.updateOne_1(yonghuming, duizhang);
        else if(i.equals("2"))
            armyRepositories.updateTwo_1(yonghuming, duizhang);
        else if(i.equals("3"))
            armyRepositories.updateThree_1(yonghuming,duizhang);
    }

    @Override
    public void updataduiyuan(String yonghuming, String duizhang) {
        armyRepositories.updateduiyuan(yonghuming, duizhang);
    }

    @Override
    public void updataDuiyuan(String shenqingren, String duizhang) {
         armyRepositories.updateDuiyuan(shenqingren,duizhang);
    }

}
