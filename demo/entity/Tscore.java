package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tuantichengji")
@DynamicInsert
@DynamicUpdate
@Data
public class Tscore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bisaishijian;
    private String bisaididian;
    private String cansaizhe1;
    private String cansaizhe2;
    private String bifen1_1;
    private String bifen1_2;
    private String bifen1_3;
    private String bifen2_1;
    private String bifen2_2;
    private String bifen2_3;
    private String bifen3_1;
    private String bifen3_2;
    private String bifen3_3;
    private String bifen4_1;
    private String bifen4_2;
    private String bifen4_3;
    private String bifen5_1;
    private String bifen5_2;
    private String bifen5_3;
    private String beizhu;
}
