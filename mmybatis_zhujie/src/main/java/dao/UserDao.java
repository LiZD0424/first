package dao;


import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
@CacheNamespace(blocking = true)//注解开启二级缓存要两步，第一步配置SqlMapConfig.xml（这里面默认开启二级缓存所以不用动），第二步加上这个注解，没有第三步
public interface UserDao {
    @Select("select * from user")
    @Results(id = "userMap",value = {//解决数据库字段名和实体类中成员变量名不匹配问题
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "address",property = "address"),
            @Result(column = "birthday",property = "birthday")
    })
    List<User> findAll();
    @Update("update user set username=#{username} where id=#{id}")
    void updataById(User user);
    @Insert("insert into user (username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void insertUser(User user);
    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);
    @Select("select * from user where username like #{username}")
    @ResultMap(value = {"userMap"})//使用上方定义好的resultMap
    List<User> findByName(String username);
    @Select("select count(id) from user")
    int totalUser();
    @Select("select * from user where id=#{id}")
    User findUserById(int id);
    @Select("select * from user")
    @Results(id = "AllUser",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "address",property = "address"),
            @Result(column = "birthday",property = "birthday"),
            @Result(property = "list",column = "id",many = @Many(select = "dao.AccountDao.findByUid",fetchType = FetchType.DEFAULT))
    })
    List<User> findAllUser();
}
