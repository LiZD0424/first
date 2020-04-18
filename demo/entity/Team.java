package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tuantixinxi")
@DynamicInsert
@DynamicUpdate
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tuantimingcheng;
    private String tuanzhang;
    private String tuanyuan1;
    private String tuanyuan2;
    private String tuanzhanglianxi;
    private String shenqingren1;
    private String shenqingren2;
    private String shenqingren3;
}
