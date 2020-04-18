package com.example.demo.repositories;

import com.example.demo.entity.Sscore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SscoreRepositories extends JpaRepository<Sscore,Integer> {
    public List<Sscore>findByCansaizhe1AndBisaileixing(String cansaizhe1,String bisaileixing);
    public List<Sscore>findByCansaizhe2AndBisaileixing(String cansaizhe2,String bisaileixing);
    //@Query(value="select cansaizhe1 from danshuangdachengji u where u.cansaizh=?1 ",nativeQuery = true)
    //public String findDuiwumingchengByDuizhang(String duizhang);
}
