package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "shenqingxinxi")
@DynamicInsert
@DynamicUpdate
@Data
public class AppInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String shenqingren;
    private String biangengqianmingcheng;
    private String biangenghoumingcheng;
    private String bisaileixing;
    private String biangengliyou;
    private String shenqingzhuangtai;

}
