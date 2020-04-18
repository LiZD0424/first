package com.example.demo.repositories;

import com.example.demo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TeamRepositories extends JpaRepository<Team,Integer> {
    public List<Team> findByTuantimingcheng(String tuantimingcheng);
    public List<Team> findByTuanzhang(String tuanzhang);
    @Query(value="select tuantimingcheng from tuantixinxi u where u.tuanzhang=?1 ",nativeQuery = true)
    public String findTuantimingchengByTuanzhang(String tuanzhang);
    @Query(value="select tuantimingcheng from tuantixinxi u where u.tuanyuan1=?1 ",nativeQuery = true)
    public String findTuantimingchengByTuanyuan1(String tuanyuan1);
    @Query(value="select tuantimingcheng from tuantixinxi u where u.tuanyuan2=?1 ",nativeQuery = true)
    public String findTuantimingchengByTuanyuan2(String tuanyuan2);
    @Query(value="select shenqingren1 from tuantixinxi u where u.tuantimingcheng=?1 ",nativeQuery = true)
    public String findShenqingren1ByTuantimingcheng(String tuantimingcheng);
    @Query(value="select shenqingren2 from tuantixinxi u where u.tuantimingcheng=?1 ",nativeQuery = true)
    public String findShenqingren2ByTuantimingcheng(String tuantimingcheng);
    @Query(value="select shenqingren3 from tuantixinxi u where u.tuantimingcheng=?1 ",nativeQuery = true)
    public String findShenqingren3ByTuantimingcheng(String tuantimingcheng);
    @Query(value = "update tuantixinxi set shenqingren1=?1 where tuantimingcheng=?2 ", nativeQuery = true)
    @Modifying
    public void updateOne(String yonghuming,String tuantimingcheng);
    @Query(value = "update Tuantixinxi set shenqingren2=?1 where tuantimingcheng=?2 ", nativeQuery = true)
    @Modifying
    public void updateTwo(String yonghuming,String tuantimingcheng);
    @Query(value = "update Tuantixinxi set shenqingren3=?1 where tuantimingcheng=?2 ", nativeQuery = true)
    @Modifying
    public void updateThree(String yonghuming,String tuantimingcheng);
    @Query(value = "update tuantixinxi set shenqingren1=?1 where tuanzhang=?2 ", nativeQuery = true)
    @Modifying
    public void updateOne_1(String yonghuming,String tuanzhang);
    @Query(value = "update Tuantixinxi set shenqingren2=?1 where tuanzhang=?2 ", nativeQuery = true)
    @Modifying
    public void updateTwo_1(String yonghuming,String tuanzhang);
    @Query(value = "update Tuantixinxi set shenqingren3=?1 where tuanzhang=?2 ", nativeQuery = true)
    @Modifying
    public void updateThree_1(String yonghuming,String tuanzhang);
    @Query(value = "update tuantixinxi set tuanyuan1=?1 where tuanzhang=?2 ", nativeQuery = true)
    @Modifying
    @Transactional
    public void updateTuanyuan1(String shenqingren,String tuanzhang);
    @Query(value = "update tuantixinxi set tuanyuan2=?1 where tuanzhang=?2 ", nativeQuery = true)
    @Modifying
    @Transactional
    public void updateTuanyuan2(String shenqingren,String tuanzhang);
    @Query(value="select tuanyuan1 from tuantixinxi u where u.tuanzhang=?1 ",nativeQuery = true)
    public String findTuanyuan1ByTuanzhang(String tuanzhang);
    @Query(value="select tuanyuan2 from tuantixinxi u where u.tuanzhang=?1 ",nativeQuery = true)
    public String findTuanyuan2ByTuanzhang(String tuanzhang);
}
