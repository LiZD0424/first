package com.example.demo.service.impl;

import com.example.demo.entity.Match;
import com.example.demo.repositories.ArmyRepositories;
import com.example.demo.repositories.MatchRepositories;
import com.example.demo.repositories.TeamRepositories;
import com.example.demo.service.ArmyService;
import com.example.demo.service.MatchService;
import com.example.demo.service.TeamService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

@Service
public class MatchSerciveImpl implements MatchService {
    @Autowired
    private MatchRepositories matchRepositories;
    @Autowired
    private ArmyRepositories armyRepositories;
    @Autowired
    private TeamRepositories teamRepositories;

    @Override
    public List<Match> getMatchList() {
        return matchRepositories.findAll();
    }

    @Override
    public Match addMatch(Match match) {
        return matchRepositories.save(match);
    }

    @Override
    public List<Match> getNoStartMatchList(String bisaileixing) {
        return matchRepositories.findByZhuangtaiAndBisaileixing("1",bisaileixing);
    }

    @Override
    @Transactional
    public int update(String yonghuming, String mingcheng,String bisaileixing) {
        if(matchRepositories.findCansaizhe1ByMingchengAndZhuangtai(mingcheng,"1",bisaileixing)!=null&&matchRepositories.findCansaizhe1ByMingchengAndZhuangtai(mingcheng,"1",bisaileixing).equals("-1")){
            matchRepositories.updateOne(yonghuming,mingcheng,"1",bisaileixing);
            return 1;
        }else if(matchRepositories.findCansaizhe1ByMingchengAndZhuangtai(mingcheng,"1",bisaileixing)!=null&&matchRepositories.findCansaizhe2ByMingchengAndZhuangtai(mingcheng,"1",bisaileixing).equals("-1")){
            matchRepositories.updateTwo(yonghuming,mingcheng,"1",bisaileixing);
            return 2;
        }else
            return 0;
    }

    @Override
    public List<Match> getRegisteredSingleMatchOfCansaizhe1(String yonghuming,String bisaileixing) {
        return matchRepositories.findByCansaizhe1AndZhuangtaiAndBisaileixing(yonghuming,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredSingleMatchOfCansaizhe2(String yonghuming,String bisaileixing) {
        return matchRepositories.findByCansaizhe2AndZhuangtaiAndBisaileixing(yonghuming,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredArmyMatchOfCansaizhe1_duizhang(String yonghuming,String bisaileixing) {
        String a=armyRepositories.findDuiwumingchengByDuizhang(yonghuming);
        return matchRepositories.findByCansaizhe1AndZhuangtaiAndBisaileixing(a,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredArmyMatchOfCansaizhe2_duizhang(String yonghuming,String bisaileixing) {
        String a=armyRepositories.findDuiwumingchengByDuizhang(yonghuming);
        return matchRepositories.findByCansaizhe2AndZhuangtaiAndBisaileixing(a,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredArmyMatchOfCansaizhe1_duiyuan(String yonghuming,String bisaileixing) {
        String a=armyRepositories.findDuiwumingchengByDuiyuan(yonghuming);
        return matchRepositories.findByCansaizhe1AndZhuangtaiAndBisaileixing(a,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredArmyMatchOfCansaizhe2_duiyuan(String yonghuming,String bisaileixing) {
        String a=armyRepositories.findDuiwumingchengByDuiyuan(yonghuming);
        return matchRepositories.findByCansaizhe2AndZhuangtaiAndBisaileixing(a,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredTeamMatchOfCansaizhe1_tuanzhang(String yonghuming,String bisaileixing) {
        String t=teamRepositories.findTuantimingchengByTuanzhang(yonghuming);
        return matchRepositories.findByCansaizhe1AndZhuangtaiAndBisaileixing(t,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredTeamMatchOfCansaizhe1_tuanyuan1(String yonghuming,String bisaileixing) {
        String t=teamRepositories.findTuantimingchengByTuanyuan1(yonghuming);
        return matchRepositories.findByCansaizhe1AndZhuangtaiAndBisaileixing(t,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredTeamMatchOfCansaizhe1_tuanyuan2(String yonghuming,String bisaileixing) {
        String t=teamRepositories.findTuantimingchengByTuanyuan2(yonghuming);
        return matchRepositories.findByCansaizhe1AndZhuangtaiAndBisaileixing(t,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredTeamMatchOfCansaizhe2_tuanzhang(String yonghuming,String bisaileixing) {
        String t=teamRepositories.findTuantimingchengByTuanzhang(yonghuming);
        return matchRepositories.findByCansaizhe2AndZhuangtaiAndBisaileixing(t,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredTeamMatchOfCansaizhe2_tuanyuan1(String yonghuming,String bisaileixing) {
        String t=teamRepositories.findTuantimingchengByTuanyuan1(yonghuming);
        return matchRepositories.findByCansaizhe2AndZhuangtaiAndBisaileixing(t,"1",bisaileixing);
    }

    @Override
    public List<Match> getRegisteredTeamMatchOfCansaizhe2_tuanyuan2(String yonghuming,String bisaileixing) {
        String t=teamRepositories.findTuantimingchengByTuanyuan2(yonghuming);
        return matchRepositories.findByCansaizhe2AndZhuangtaiAndBisaileixing(t,"1",bisaileixing);
    }

    @Override
    @Transactional
    public void restoreArmyCansaizhe(String yonghuming,String mingcheng) {
        String a =armyRepositories.findDuiwumingchengByDuizhang(yonghuming);
        //String t=teamRepositories.findTuanyuan1ByTuanzhang(yonghuming);
        if(matchRepositories.findCansaizhe1ByMingchengAndZhuangtai(mingcheng,"1","2").equals(a))
            matchRepositories.updateOne("-1",mingcheng,"1","2");
        else if(matchRepositories.findCansaizhe2ByMingchengAndZhuangtai(mingcheng,"1","2").equals(a))
            matchRepositories.updateTwo("-1",mingcheng,"1","2");
        else ;
    }
    @Override
    @Transactional
    public void restoreTeamCansaizhe(String yonghuming,String mingcheng) {
        //String a =armyRepositories.findDuiwumingchengByDuizhang(yonghuming);
        String t=teamRepositories.findTuantimingchengByTuanzhang(yonghuming);
        if(matchRepositories.findCansaizhe1ByMingchengAndZhuangtai(mingcheng,"1","3").equals(t))
            matchRepositories.updateOne("-1",mingcheng,"1","3");
        else  if(matchRepositories.findCansaizhe2ByMingchengAndZhuangtai(mingcheng,"1","3").equals(t))
            matchRepositories.updateTwo("-1",mingcheng,"1","3");
        else ;
    }

    @Override
    @Transactional
    public void restoreSingleCansaizhe(String yonghuming, String mingcheng) {
        if(matchRepositories.findCansaizhe1ByMingchengAndZhuangtai(mingcheng,"1","1").equals(yonghuming))
            matchRepositories.updateOne("-1",mingcheng,"1","1");
        else if(matchRepositories.findCansaizhe2ByMingchengAndZhuangtai(mingcheng,"1","1").equals(yonghuming))
            matchRepositories.updateTwo("-1",mingcheng,"1","1");
        else ;
    }

    @Override
    @Transactional
    public int changeMatch(String yonghuming, String mingcheng, String bisaileixing) {
        String a=armyRepositories.findDuiwumingchengByDuizhang(yonghuming);
        String t=teamRepositories.findTuantimingchengByTuanzhang(yonghuming);
        if(bisaileixing.equals("1"))
            return update(yonghuming, mingcheng, "1");
        else if(bisaileixing.equals("2"))
            return update(a,mingcheng,"2");
        else
            return update(t,mingcheng,"3");
    }

    @Override
    public List<Match> getNoCaipanList(String bisaileixing) {
        return matchRepositories.findByZhuangtaiAndBisaileixingAndCaipan("1",bisaileixing,"-1");
    }

    @Override
    public void updatacaipan(String bisaileixing, String mingcheng,String yonghuming) {
        matchRepositories.updateCaipan(yonghuming,mingcheng,"1",bisaileixing);
    }

    @Override
    public List<Match> selectMatchByCaipan(String yonghuming, String bisaileixing) {
        return matchRepositories.findByZhuangtaiAndBisaileixingAndCaipan("1",bisaileixing,yonghuming);
    }

    @Override
    public List<Match> getMatchByCaipanAndBisaileixing(String caipan,String bisialeixing) {
        return matchRepositories.findByZhuangtaiAndBisaileixingAndCaipan("1",bisialeixing,caipan);
    }

    @Override
    public void updataZhuangtai(String mingcheng, String bisaileixing) {
        matchRepositories.updateZhuangtai("2",mingcheng,bisaileixing);
    }

    @Override
    public List<Match> getMatchByChuangjianzhe(String chuangjianzhe) {
        return matchRepositories.findByChuangjianzheAndZhuangtai(chuangjianzhe,"1");
    }

    @Override
    public void updataBisaishijian(String bisaishijian, int id) {
        matchRepositories.updateBisaishijian(bisaishijian,id);
    }

    @Override
    public void updataBisaididian(String bisaididian, int id) {
        matchRepositories.updateBisaididian(bisaididian, id);
    }

    @Override
    public void updataBisaileixing(String bisaileixing, int id) {
        matchRepositories.updateBisaileixing(bisaileixing, id);
    }

    @Override
    public void updataMingcheng(String mingcheng, int id) {
        matchRepositories.updateMingcheng(mingcheng, id);
    }

    @Override
    public Map<String, String> getShijianAndDidianAndMingcheng(int id) {
        return matchRepositories.getTimeAndPlaceAndMingchengAndBisaileixing(id);
    }
}
