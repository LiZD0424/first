package com.example.demo.repositories;

import com.example.demo.entity.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface AppInfoRepositories extends JpaRepository<AppInfo,Integer> {
    public List<AppInfo> findByShenqingzhuangtai(String shenqingzhuangtai);
    @Query(value="select biangenghoumingcheng from shenqingxinxi u where u.id=?1  ",nativeQuery = true)
    public String findMingcheng2(int id);
    @Query(value="select biangengqianmingcheng from shenqingxinxi u where u.id=?1  ",nativeQuery = true)
    public String findMingcheng1(int id);
    @Query(value="select bisaileixing from shenqingxinxi u where u.id=?1  ",nativeQuery = true)
    public String findBisaileixing(int id);
    @Query(value="select shenqingren from shenqingxinxi u where u.id=?1  ",nativeQuery = true)
    public String findShenqingren(int id);
    @Transactional
    @Query(value = "update shenqingxinxi set shenqingzhuangtai=?1 where id=?2 ", nativeQuery = true)
    @Modifying
    public void refuse(String shengqingzhuangtai,int id);
}
