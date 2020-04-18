package com.example.demo.service;

import com.example.demo.entity.Match;

import java.util.List;
import java.util.Map;

public interface MatchService {
    public List<Match> getMatchList();
    public Match addMatch(Match match);
    public List<Match> getMatchByCaipanAndBisaileixing(String caipan,String bisaileixing);
    public List<Match> getNoStartMatchList(String bisaileixing);
    public int update(String yonghuming,String mingcheng,String bisaileixing);
    public List<Match> getRegisteredSingleMatchOfCansaizhe1(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredSingleMatchOfCansaizhe2(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredArmyMatchOfCansaizhe1_duizhang(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredArmyMatchOfCansaizhe2_duizhang(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredArmyMatchOfCansaizhe1_duiyuan(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredArmyMatchOfCansaizhe2_duiyuan(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredTeamMatchOfCansaizhe1_tuanzhang(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredTeamMatchOfCansaizhe1_tuanyuan1(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredTeamMatchOfCansaizhe1_tuanyuan2(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredTeamMatchOfCansaizhe2_tuanzhang(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredTeamMatchOfCansaizhe2_tuanyuan1(String yonghuming,String bisaileixing);
    public List<Match> getRegisteredTeamMatchOfCansaizhe2_tuanyuan2(String yonghuming,String bisaileixing);
    public void restoreArmyCansaizhe(String yonghuming,String mingcheng);
    public void restoreTeamCansaizhe(String yonghuming,String mingcheng);
    public void restoreSingleCansaizhe(String yonghuming,String mingcheng);
    public int changeMatch(String yonghuming,String mingcheng,String bisaileixing );
    public List<Match>getNoCaipanList(String bisaileixing);
    public void updatacaipan(String bisaileixing,String mingcheng,String yonghuming);
    public List<Match>selectMatchByCaipan(String yonghuming,String bisaileixing);
    public void updataZhuangtai(String mingcheng,String bisaileixing);
    public List<Match>getMatchByChuangjianzhe(String chuangjianzhe);
    public void updataBisaishijian(String bisaishijian,int id);
    public void updataBisaididian(String bisaididian,int id);
    public void updataBisaileixing(String bisaileixing,int id);
    public void updataMingcheng(String mingcheng,int id);
    public Map<String, String>getShijianAndDidianAndMingcheng(int id);
}
