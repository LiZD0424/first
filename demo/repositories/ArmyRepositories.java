package com.example.demo.repositories;

import com.example.demo.entity.Army;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ArmyRepositories extends JpaRepository<Army,Integer> {
    public List<Army> findByDuiwumingcheng(String duiwumingcheng);
    public List<Army> findByDuizhang(String duizhang);
    @Query(value="select duiwumingcheng from duiwuxinxi u where u.duizhang=?1 ",nativeQuery = true)
    public String findDuiwumingchengByDuizhang(String duizhang);
    @Query(value="select duiwumingcheng from duiwuxinxi u where u.duiyuan=?1 ",nativeQuery = true)
    public String findDuiwumingchengByDuiyuan(String duiyuan);
    @Query(value="select shenqingren1 from duiwuxinxi u where u.duiwumingcheng=?1 ",nativeQuery = true)
    public String findShenqingren1ByDuiwumingcheng(String duiwumingcheng);
    @Query(value="select shenqingren2 from duiwuxinxi u where u.duiwumingcheng=?1 ",nativeQuery = true)
    public String findShenqingren2ByDuiwumingcheng(String duiwumingcheng);
    @Query(value="select shenqingren3 from duiwuxinxi u where u.duiwumingcheng=?1 ",nativeQuery = true)
    public String findShenqingren3ByDuiwumingcheng(String duiwumingcheng);
    @Query(value = "update duiwuxinxi set shenqingren1=?1 where duiwumingcheng=?2 ", nativeQuery = true)
    @Modifying
    public void updateOne(String yonghuming,String duiwumingcheng);
    @Query(value = "update Duiwuxinxi set shenqingren2=?1 where duiwumingcheng=?2 ", nativeQuery = true)
    @Modifying
    public void updateTwo(String yonghuming,String duiwumingcheng);
    @Query(value = "update Duiwuxinxi set shenqingren3=?1 where duiwumingcheng=?2 ", nativeQuery = true)
    @Modifying
    public void updateThree(String yonghuming,String duiwumingcheng);
    @Query(value = "update duiwuxinxi set duiyuan=?1 where duizhang=?2 ", nativeQuery = true)
    @Modifying
    @Transactional
    public void updateDuiyuan(String shenqingren,String duizhang);
    @Query(value = "update duiwuxinxi set shenqingren1=?1 where duizhang=?2 ", nativeQuery = true)
    @Modifying
    public void updateOne_1(String yonghuming,String duizhang);
    @Query(value = "update Duiwuxinxi set shenqingren2=?1 where duizhang=?2 ", nativeQuery = true)
    @Modifying
    public void updateTwo_1(String yonghuming,String duizhang);
    @Query(value = "update Duiwuxinxi set shenqingren3=?1 where duizhang=?2 ", nativeQuery = true)
    @Modifying
    public void updateThree_1(String yonghuming,String duizhang);
    @Query(value = "update Duiwuxinxi set duiyuan=?1 where duizhang=?2 ", nativeQuery = true)
    @Modifying
    @Transactional
    public void updateduiyuan(String yonghuming,String duizhang);
}

