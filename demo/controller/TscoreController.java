package com.example.demo.controller;

import com.example.demo.entity.Tscore;
import com.example.demo.repositories.MatchRepositories;
import com.example.demo.service.TscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tscore")
public class TscoreController {
    @Autowired
    private TscoreService tscoreService;
    @Autowired
    private MatchRepositories matchRepositories;
    @GetMapping
    public List<Tscore> getTscoreList(){
        return tscoreService.getTscoreList();
    }
    @PostMapping
    public Tscore addTscore(@RequestParam("mingcheng") String mingcheng, @RequestParam("bisaileixing") String bisaileixing, @RequestParam("bifen11") String bifen1_1, @RequestParam("bifen12") String bifen1_2, @RequestParam("bifen13") String bifen1_3, @RequestParam("beizhu") String beizhu, @RequestParam("bifen21") String bifen2_1, @RequestParam("bifen22") String bifen2_2, @RequestParam("bifen23") String bifen2_3, @RequestParam("bifen31") String bifen3_1, @RequestParam("bifen32") String bifen3_2, @RequestParam("bifen33") String bifen3_3, @RequestParam("bifen41") String bifen4_1, @RequestParam("bifen42") String bifen4_2, @RequestParam("bifen43") String bifen4_3, @RequestParam("bifen51") String bifen5_1, @RequestParam("bifen52") String bifen5_2, @RequestParam("bifen53") String bifen5_3) {
        matchRepositories.updateZhuangtai("2",mingcheng,bisaileixing);
        Tscore tscore = new Tscore();
        String bisaishijian=matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing).get("bisaishijian");
        String bisaididian=matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing).get("bisaididian");
        String cansaizhe1=matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing).get("cansaizhe1");
        String cansaizhe2=matchRepositories.getTimeAndPlaceAndCansaizhe(mingcheng,bisaileixing).get("cansaizhe2");
        tscore.setBisaididian(bisaididian);
        tscore.setBisaishijian(bisaishijian);
        tscore.setCansaizhe1(cansaizhe1);
        tscore.setCansaizhe2(cansaizhe2);
        tscore.setBeizhu(beizhu);
        tscore.setBifen1_1(bifen1_1);
        tscore.setBifen1_2(bifen1_2);
        tscore.setBifen1_3(bifen1_3);
        tscore.setBifen2_1(bifen2_1);
        tscore.setBifen2_2(bifen2_2);
        tscore.setBifen2_3(bifen2_3);
        tscore.setBifen3_1(bifen3_1);
        tscore.setBifen3_2(bifen3_2);
        tscore.setBifen3_3(bifen3_3);
        tscore.setBifen4_1(bifen4_1);
        tscore.setBifen4_2(bifen4_2);
        tscore.setBifen4_3(bifen4_3);
        tscore.setBifen5_1(bifen5_1);
        tscore.setBifen5_2(bifen5_2);
        tscore.setBifen5_3(bifen5_3);
        return tscoreService.addTscore(tscore);
    }
    @PostMapping("/find")
    public List<Tscore> findList(@RequestParam("yonghuming")String yonghuming){
        return tscoreService.getSscore(yonghuming);
    }
 }
