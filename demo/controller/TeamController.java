package com.example.demo.controller;

import com.example.demo.entity.Team;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping
    public List<Team> getTeamList(){
        return teamService.getTeamList();
    }
    @PostMapping
    public Team addTeam(@RequestParam("tuantimingcheng") String tuantimingcheng,@RequestParam("tuanzhanglianxi") String tuanzhanglianxi,@RequestParam("tuanzhang") String tuanzhang ){
        Team team=new Team();
        team.setTuantimingcheng(tuantimingcheng);
        team.setTuanzhang(tuanzhang);
        team.setTuanyuan1("-1");
        team.setTuanyuan2("-1");
        team.setTuanzhanglianxi(tuanzhanglianxi);
        team.setShenqingren1("-1");
        team.setShenqingren2("-1");
        team.setShenqingren3("-1");
        return teamService.addTeam(team);
    }
    @PostMapping("/find")
    public List<Team> getTeamListByTuantimingcheng(@RequestParam("tuantimingcheng") String tuantimingcheng){
        return teamService.getTeamListByTuantimingcheng(tuantimingcheng);
    }
    @PostMapping("/find/app")
    public int updata(@RequestParam("yonghuming") String yonghuming,@RequestParam("tuantimingcheng") String tuantimingcheng){
        return teamService.updata(yonghuming, tuantimingcheng);
    }
    @PostMapping("/find/tuanzhang")
    public List<Team> getTeamByTuanzhang(@RequestParam("tuanzhang")String tuanzhang){
        return teamService.getTeamListByTuanzhang(tuanzhang);
    }
    @PostMapping("/find/app/jujue")
    public void updataShenqingren(@RequestParam("tuanzhang") String tuanzhang,@RequestParam("i") String i){
        teamService.updata_1("-1",tuanzhang,i);
    }
    @PostMapping("/find/app/shouli")
    public int updataTuanyuan(@RequestParam("shenqingren") String shenqingren,@RequestParam("tuanzhang")String tuanzhang){
        return teamService.updataTuanyuan(shenqingren, tuanzhang);
    }
    @PostMapping("/tuantiguanli")
    public void deleteTuanyuan(@RequestParam("tuanzhang") String tuanzhang,@RequestParam("j")String j){
        teamService.deleteTuanyuan("-1",tuanzhang,j);
    }
}
