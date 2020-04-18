package com.example.demo.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DynamicInsert
@DynamicUpdate
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //用户id
        private int id;
        //用户名
        private String yonghuming;
        //户密码
        private String mima;
        //用户权限
        private String quanxian;
        //联系方式
        private String lianxifangshi;
        public User(){}

}
