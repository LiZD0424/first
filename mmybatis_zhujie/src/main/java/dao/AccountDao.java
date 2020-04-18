package dao;

import domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    //一对一，多对一用one注解，fetchType有三种LAZY, EAGER, DEFAULT，延迟、立即、默认，默认一对一、多对一用立即，一对多、多对多用延迟
    @Select("select * from account")
    @Results(id = "allAccount", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "money", column = "money"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "user",column = "uid",one = @One(select = "dao.UserDao.findUserById",fetchType = FetchType.DEFAULT))
    })
    List<Account> findAll();
    @Select("select * from account where uid=#{uid}")
    List<Account> findByUid(int uid);
}
