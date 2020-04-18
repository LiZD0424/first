package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "match1")
@DynamicInsert
@DynamicUpdate
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //时间
    private String bisaishijian;
    //名称
    private String mingcheng;
    //地点
    private String bisaididian;
    //类型
    private String bisaileixing;
    //参赛者
    private String cansaizhe1;
    private String cansaizhe2;
    //裁判
    private String caipan;
    //比赛状态
    private String zhuangtai;
    private String chuangjianzhe;
    public Match(){}
}
