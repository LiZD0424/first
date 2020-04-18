package springbootmybatis.sbmybatis.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import springbootmybatis.sbmybatis.domain.User;

import java.util.List;
@Mapper
@Component //加上这个使spring认为这个类是spring工程的一部分，防止自动注入错误
public interface UserDao {
    List<User> findAll();
}
