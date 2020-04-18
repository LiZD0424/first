package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "danshuangdachengji")
@DynamicInsert
@DynamicUpdate
@Data
public class Sscore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bisaishijian;
    private String bisaididian;
    private String cansaizhe1;
    private String cansaizhe2;
    private String bifen1;
    private String bifen2;
    private String bifen3;
    private String bisaileixing;
}
