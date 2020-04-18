package com.example.demo.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "duiwuxinxi")
@DynamicInsert
@DynamicUpdate
@Data
public class Army {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //队伍名称
    private String duiwumingcheng;
    //队长
    private String duizhang;
    //队员
    private String duiyuan;
    private String duizhanglianxi;
    private String duiyuanlianxi;
    private String shenqingren1;
    private String shenqingren2;
    private String shenqingren3;
    public Army(){}
}
