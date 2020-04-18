package com.example.demo.controller;

import com.example.demo.entity.Match;
import com.example.demo.repositories.MatchRepositories;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;
    @Autowired
    private MatchRepositories matchRepositories;
    @GetMapping
    public List<Match> getMatchlist(){
        return matchService.getMatchList();
    }
    @PostMapping
    public Match addMatch(@RequestParam("chuangjianzhe") String chuangjianzhe,@RequestParam("mingcheng") String mingcheng,@RequestParam("bisaishijian") String bisaishijian , @RequestParam("bisaididian") String bisaididian, @RequestParam("bisaileixing") String bisaileixing, @RequestParam("zhuangtai") String zhuangtai){
        Match match=new Match();
        match.setBisaididian(bisaididian);
        match.setMingcheng(mingcheng);
        match.setBisaileixing(bisaileixing);
        match.setBisaishijian(bisaishijian);
        match.setZhuangtai(zhuangtai);
        match.setChuangjianzhe(chuangjianzhe);
        match.setCansaizhe1("-1");
        match.setCansaizhe2("-1");
        match.setCaipan("-1");
        return matchService.addMatch(match);
    }
    @PostMapping("/single")
    public List<Match> getNoStartMatchlist(@RequestParam("bisaileixing") String bisaileixing){
        return matchService.getNoStartMatchList(bisaileixing);
    }
    @PostMapping("/single/enroll")
    public int update(@RequestParam("yonghuming") String yonghuming, @RequestParam("mingcheng") String mingcheng, @RequestParam("bisaileixing") String bisaileixing) {
        return matchService.update(yonghuming,mingcheng,bisaileixing);
    }
    /*public Boolean getMatch(@RequestParam("mingcheng") String mingcheng){
        String k=matchRepositories.findCansaizhe1ByMingchengAndZhuangtai(mingcheng,"1");
        return k.equals("xx");//matchRepositories.findCansaizhe1ByMingchengAndZhuangtai(mingcheng,"1")
    }*/
    @PostMapping("/find/xiugai/cansaizhe1")
    public List<Match> getRegisteredMatch1(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing){
        if(bisaileixing.equals("1"))
            return matchService.getRegisteredSingleMatchOfCansaizhe1(yonghuming,bisaileixing);
        else if(bisaileixing.equals("2"))
            return matchService.getRegisteredArmyMatchOfCansaizhe1_duizhang(yonghuming,bisaileixing);
        else
            return matchService.getRegisteredTeamMatchOfCansaizhe1_tuanzhang(yonghuming,bisaileixing);
    }
    @PostMapping("/find/xiugai/cansaizhe2")
    public List<Match> getRegisteredMatch2(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing){
        if(bisaileixing.equals("1"))
            return matchService.getRegisteredSingleMatchOfCansaizhe2(yonghuming,bisaileixing);
        else if(bisaileixing.equals("2"))
            return matchService.getRegisteredArmyMatchOfCansaizhe2_duizhang(yonghuming,bisaileixing);
        else
            return matchService.getRegisteredTeamMatchOfCansaizhe2_tuanzhang(yonghuming,bisaileixing);
    }
    @PostMapping("/find/noxiugai/cansaizhe1")
    public List<Match> getRegisteredMatch3(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing){
        if (bisaileixing.equals("2"))
            return matchService.getRegisteredArmyMatchOfCansaizhe1_duiyuan(yonghuming,bisaileixing);
        else{
            List<Match> L1=matchService.getRegisteredTeamMatchOfCansaizhe1_tuanyuan1(yonghuming,bisaileixing);
            List<Match> L2=matchService.getRegisteredTeamMatchOfCansaizhe1_tuanyuan2(yonghuming,bisaileixing);
            if(L1.isEmpty())
                return L2;
            else
                L1.addAll(L2);
                return L1;
        }
    }
    @PostMapping("/find/noxiugai/cansaizhe2")
    public List<Match> getRegisteredMatch4(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing) {
        if (bisaileixing.equals("2"))
            return matchService.getRegisteredArmyMatchOfCansaizhe2_duiyuan(yonghuming, bisaileixing);
        else {
            List<Match> L1 = matchService.getRegisteredTeamMatchOfCansaizhe2_tuanyuan1(yonghuming, bisaileixing);
            List<Match> L2 = matchService.getRegisteredTeamMatchOfCansaizhe2_tuanyuan2(yonghuming, bisaileixing);
            if (L1.isEmpty())
                return L2;
            else
                L1.addAll(L2);
            return L1;
        }
    }
    @PostMapping("/restore")
    public void restoreCansaizhe(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing,@RequestParam("mingcheng")String mingcheng){
        if(bisaileixing.equals("1"))
            matchService.restoreSingleCansaizhe(yonghuming,mingcheng);
        else if(bisaileixing.equals("2"))
            matchService.restoreArmyCansaizhe(yonghuming, mingcheng);
        else
            matchService.restoreTeamCansaizhe(yonghuming,mingcheng);
    }
    @PostMapping("/change")
    public int changeMatch(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing,@RequestParam("mingcheng")String mingcheng){
        return matchService.changeMatch(yonghuming, mingcheng, bisaileixing);
    }
    @PostMapping("/referee")
    public List<Match> getNoCaipanList(@RequestParam("bisaileixing")String bisaileixing){
        return matchService.getNoCaipanList(bisaileixing);
    }
    @PostMapping("/referee/enroll")
    public void updataCaipan(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing,@RequestParam("mingcheng")String mingcheng){
        matchService.updatacaipan(bisaileixing,mingcheng,yonghuming);
    }
    @PostMapping("/referee/me")
    public List<Match> selectMatchByCaipan(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing){
        return matchService.selectMatchByCaipan(yonghuming,bisaileixing);
    }
    @PostMapping("/referee/app")
    public  Map<String, String>getTimeAndPlace(@RequestParam("mingcheng")String mingcheng,@RequestParam("bisaileixing")String bisaileixing){
        return matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing);
    }
    @PostMapping("/find/caipan")
    public List<Match> findMatchByCaipan(@RequestParam("caipan") String caipan,@RequestParam("bisialeixing") String bisaileixing){
        return matchService.getMatchByCaipanAndBisaileixing(caipan, bisaileixing);
    }
    @PostMapping("/find/chuangjianzhe")
    public List<Match> findMatchByChuangjianzhe(@RequestParam("chuangjianzhe")String chuangjianzhe){
        return matchService.getMatchByChuangjianzhe(chuangjianzhe);
    }
    @PostMapping("/update/bisaishijian")
    public void updateBisaishijian(@RequestParam("bisaishijian") String bisaishijian,@RequestParam("id") int id){
        matchService.updataBisaishijian(bisaishijian, id);
    }
    @PostMapping("/update/bisaididian")
    public void updateBisaididian(@RequestParam("bisaididian") String bisaididian,@RequestParam("id") int id){
        matchService.updataBisaididian(bisaididian, id);
    }
    @PostMapping("/update/bisaileixing")
    public void updateBisaileixing(@RequestParam("bisaileixing") String bisaileixing,@RequestParam("id") int id){
        matchService.updataBisaileixing(bisaileixing, id);
    }
    @PostMapping("/update/mingcheng")
    public void updateMingcheng(@RequestParam ("mingcheng")String mingcheng,@RequestParam("id") int id){
        matchService.updataMingcheng(mingcheng,id);
    }
    @PostMapping("/getSDLM")
    public Map<String, String>getSDLM(@RequestParam("id")int id){
       return matchService.getShijianAndDidianAndMingcheng(id);
    }
}
