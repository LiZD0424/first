package com.example.demo.controller;

import com.example.demo.entity.Sscore;
import com.example.demo.repositories.MatchRepositories;
import com.example.demo.service.MatchService;
import com.example.demo.service.SscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sscore")
public class SscoreController {
    @Autowired
    private SscoreService sscoreService;
    @Autowired
    private MatchRepositories matchRepositories;
    @GetMapping
    public List<Sscore> getSscoreList(){
        return sscoreService.getSscoreList();
    }
    @PostMapping
    public Sscore addSscore( @RequestParam("mingcheng")String mingcheng ,@RequestParam("bifen1") String bifen1, @RequestParam("bifen2") String bifen2, @RequestParam("bifen3") String bifen3, @RequestParam("bisaileixing") String bisaileixing ){
        matchRepositories.updateZhuangtai("2",mingcheng,bisaileixing);
        Sscore sscore=new Sscore();
        String bisaishijian=matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing).get("bisaishijian");
        String bisaididian=matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing).get("bisaididian");
        String cansaizhe1=matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing).get("cansaizhe1");
        String cansaizhe2=matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing).get("cansaizhe2");
        sscore.setBisaishijian(bisaishijian);
        sscore.setBisaididian(bisaididian);
        sscore.setCansaizhe1(cansaizhe1);
        sscore.setCansaizhe2(cansaizhe2);
        sscore.setBifen1(bifen1);
        sscore.setBifen2(bifen2);
        sscore.setBifen3(bifen3);
        sscore.setBisaileixing(bisaileixing);
        return sscoreService.addSscore(sscore);
    }
    @PostMapping("/find")
    public List<Sscore> findList(@RequestParam("yonghuming")String yonghuming,@RequestParam("bisaileixing")String bisaileixing){
        return sscoreService.getSscore(yonghuming,bisaileixing);
    }
}
