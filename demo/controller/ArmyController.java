package com.example.demo.controller;

import com.example.demo.entity.Army;
import com.example.demo.repositories.ArmyRepositories;
import com.example.demo.service.ArmyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/army")
public class ArmyController {
    @Autowired
    private ArmyService armyService;
    @GetMapping
    public List<Army> getArmyList(){
        return armyService.getArmyList();
    }
    @PostMapping
    public Army addArmy(@RequestParam("duiwumingcheng") String duiwumingcheng , @RequestParam("duizhang") String duizhang,@RequestParam("duizhanglianxi") String duizhanglianxi){
        Army army=new Army();
        army.setDuiwumingcheng(duiwumingcheng);
        army.setDuizhang(duizhang);
        army.setDuiyuan("-1");
        army.setDuizhanglianxi(duizhanglianxi);
        army.setShenqingren1("-1");
        army.setShenqingren2("-1");
        army.setShenqingren3("-1");
        return armyService.addArmy(army);
    }
    @PostMapping("/find")
    public List<Army> getArmyListByDuiwumingcheng(@RequestParam("duiwumingcheng") String duiwumingcheng){
        return armyService.getArmyListByDuiwumingcheng(duiwumingcheng);
    }
    @PostMapping("/find/app")
    public int updata(@RequestParam("yonghuming") String yonghuming,@RequestParam("duiwumingcheng") String duiwumingcheng){
        return armyService.updata(yonghuming, duiwumingcheng);
    }
    @PostMapping("/find/duizhang")
    public List<Army> getArmyByDuizhang(@RequestParam("duizhang")String duizhang){
        return armyService.getArmyListByDuizhang(duizhang);
    }
    @PostMapping("/find/app/shouli")
    public void updataDuiyuan(@RequestParam("shenqingren") String shenqingren,@RequestParam("duizhang") String duizhang){
        armyService.updataDuiyuan(shenqingren, duizhang);
    }
    @PostMapping("/find/app/jujue")
    public void updataShenqingren(@RequestParam("duizhang") String duizhang,@RequestParam("i") String i){
        armyService.updata_1("-1",duizhang,i);
    }
    @PostMapping("/duiyuanguanli")
    public void updataduiyuan(@RequestParam("duizhang") String duizhang){
        armyService.updataduiyuan("-1",duizhang);
    }
}
