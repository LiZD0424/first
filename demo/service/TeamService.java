package com.example.demo.service;

import com.example.demo.entity.Team;

import java.util.List;

public interface TeamService {
    public List<Team> getTeamList();
    public Team addTeam(Team team);
    public List<Team> getTeamListByTuantimingcheng(String tuantimingcheng);
    public List<Team> getTeamListByTuanzhang(String tuanzhang);
    public int updata(String yonghuming,String tuantimingcheng);
    public void updata_1(String yonghuming,String tuanzhang,String i);
    public int updataTuanyuan(String shenqingren,String tuanzhang);
    public void deleteTuanyuan(String yonghuming,String tuanzhang,String j);
}
