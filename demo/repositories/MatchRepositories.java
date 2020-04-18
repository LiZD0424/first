package com.example.demo.repositories;

import com.example.demo.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface MatchRepositories extends JpaRepository<Match,Integer> {
    public List<Match> findByZhuangtaiAndBisaileixing(String zhuangtai,String bisaileixing);
    public List<Match> findByCaipanAndBisaileixing(String caipan,String bisaileixing);
    public List<Match> findByZhuangtaiAndBisaileixingAndCaipan(String zhuangtai,String bisaileixing,String caipan);
    public List<Match> findByChuangjianzheAndZhuangtai(String chuangjianzhe,String zhuangtai );
    @Query(value="select caipan from Match1 u where u.mingcheng=?1 AND u.zhuangtai=?2 AND u.bisaileixing=?3",nativeQuery = true)
    public String findCaipan(String mingcheng,String zhuangtai,String bisaileixing);
    @Query(value="select cansaizhe1 from Match1 u where u.mingcheng=?1 AND u.zhuangtai=?2 AND u.bisaileixing=?3",nativeQuery = true)
    public String findCansaizhe1ByMingchengAndZhuangtai(String mingcheng,String zhuangtai,String bisaileixing);
    @Query(value = "select bisaishijian ,bisaididian,cansaizhe1,cansaizhe2 from Match1 m where m.mingcheng=?1 AND m.bisaileixing=?2",nativeQuery = true)
    public Map<String, String> getTimeAndPlaceAndCansaizhe(String mingcheng,String bisaileixing);
    @Query(value = "select bisaishijian ,bisaididian,bisaileixing,mingcheng from Match1 m where m.id=?1",nativeQuery = true)
    public Map<String, String> getTimeAndPlaceAndMingchengAndBisaileixing(int id);
    @Query(value="select cansaizhe2 from Match1 u where u.mingcheng=?1 AND u.zhuangtai=?2 AND u.bisaileixing=?3",nativeQuery = true)
    public String findCansaizhe2ByMingchengAndZhuangtai(String mingcheng,String zhuangtai,String bisaileixing );
    @Query(value = "update Match1 set cansaizhe1=?1 where mingcheng=?2 AND zhuangtai=?3 AND bisaileixing=?4", nativeQuery = true)
    @Modifying
    public void updateOne(String yonghuming,String mingcheng,String zhuangtai,String bisaileixing);
    @Query(value = "update Match1 set cansaizhe2=?1 where mingcheng=?2 AND zhuangtai=?3 AND bisaileixing=?4", nativeQuery = true)
    @Modifying
    public void updateTwo(String yonghuming,String mingcheng,String zhuangtai,String bisaileixing);
    public List<Match> findByCansaizhe1AndZhuangtaiAndBisaileixing(String cansaizhe1,String zhuangtai,String bisaileixing);
    public List<Match> findByCansaizhe2AndZhuangtaiAndBisaileixing(String cansaizhe2,String zhuangtai,String bisaileixing);
    @Transactional
    @Query(value = "update Match1 set caipan=?1 where mingcheng=?2 AND zhuangtai=?3 AND bisaileixing=?4", nativeQuery = true)
    @Modifying
    public void updateCaipan(String yonghuming,String mingcheng,String zhuangtai,String bisaileixing);
    @Transactional
    @Query(value = "update Match1 set zhuangtai=?1 where mingcheng=?2 AND bisaileixing=?3", nativeQuery = true)
    @Modifying
    public void updateZhuangtai(String zhuangtai,String mingcheng,String bisaileixing);
    @Transactional
    @Query(value = "update Match1 set bisaishijian=?1 where id=?2 ", nativeQuery = true)
    @Modifying
    public void updateBisaishijian(String bisaishijian,int id);
    @Transactional
    @Query(value = "update Match1 set bisaididian=?1 where id=?2 ", nativeQuery = true)
    @Modifying
    public void updateBisaididian(String bisaididian,int id);
    @Transactional
    @Query(value = "update Match1 set bisaileixing=?1 where id=?2 ", nativeQuery = true)
    @Modifying
    public void updateBisaileixing(String bisaileixing,int id);
    @Transactional
    @Query(value = "update Match1 set mingcheng=?1 where id=?2 ", nativeQuery = true)
    @Modifying
    public void updateMingcheng(String mingcheng,int id);
}
