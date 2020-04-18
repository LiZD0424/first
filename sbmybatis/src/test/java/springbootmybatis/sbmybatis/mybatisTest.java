package springbootmybatis.sbmybatis;

import org.junit.Test;//Test必须得导这个包，不能是org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootmybatis.sbmybatis.Dao.UserDao;
import springbootmybatis.sbmybatis.domain.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SbmybatisApplication.class)
public class mybatisTest {
    @Autowired
    UserDao userDao;
    @Test
    public void findAllTest(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

}
