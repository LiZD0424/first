package com.example.demo.service.impl;

import com.example.demo.entity.Team;
import com.example.demo.repositories.TeamRepositories;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepositories teamRepositories;

    @Override
    public List<Team> getTeamList() {
        return teamRepositories.findAll();
    }

    @Override
    public Team addTeam(Team team) {
        return teamRepositories.save(team);
    }

    @Override
    public List<Team> getTeamListByTuantimingcheng(String tuantimingcheng) {
        return teamRepositories.findByTuantimingcheng(tuantimingcheng);
    }
    @Override
    @Transactional
    public int updata(String yonghuming, String tuantimingcheng) {
        if(teamRepositories.findShenqingren1ByTuantimingcheng(tuantimingcheng)==null){
            return -1;
        }else if(teamRepositories.findShenqingren2ByTuantimingcheng(tuantimingcheng).equals("-1")){
            teamRepositories.updateTwo(yonghuming,tuantimingcheng);
            return 2;
        }else if(teamRepositories.findShenqingren3ByTuantimingcheng(tuantimingcheng).equals("-1")){
            teamRepositories.updateThree(yonghuming,tuantimingcheng);
            return 3;
        }else if(teamRepositories.findShenqingren1ByTuantimingcheng(tuantimingcheng).equals("-1")){
            teamRepositories.updateOne(yonghuming,tuantimingcheng);
            return 1;
        } else
            return 0;
    }

    @Override
    public List<Team> getTeamListByTuanzhang(String tuanzhang) {
        return teamRepositories.findByTuanzhang(tuanzhang);
    }

    @Override
    @Transactional
    public void updata_1(String yonghuming, String tuanzhang,String i) {
        if(i.equals("1"))
            teamRepositories.updateOne_1(yonghuming, tuanzhang);
        else if(i.equals("2"))
            teamRepositories.updateTwo_1(yonghuming, tuanzhang);
        else if(i.equals("3"))
            teamRepositories.updateThree_1(yonghuming,tuanzhang);
    }

    @Override
    public int updataTuanyuan(String shenqingren, String tuanzhang) {
        if(teamRepositories.findTuanyuan1ByTuanzhang(tuanzhang)!=null&&teamRepositories.findTuanyuan1ByTuanzhang(tuanzhang).equals("-1")){
            teamRepositories.updateTuanyuan1(shenqingren, tuanzhang);
            return 1;
        }
        else if(teamRepositories.findTuanyuan1ByTuanzhang(tuanzhang)!=null&&teamRepositories.findTuanyuan2ByTuanzhang(tuanzhang).equals("-1")){
            teamRepositories.updateTuanyuan2(shenqingren, tuanzhang);
            return 2;
        }
        else
            return 0;
    }

    @Override
    public void deleteTuanyuan(String yonghuming, String tuanzhang, String j) {
        if(j.equals("1"))
            teamRepositories.updateTuanyuan1(yonghuming,tuanzhang);
        else
            teamRepositories.updateTuanyuan2(yonghuming,tuanzhang);
    }

}
