import com.mysql.cj.Session;
import dao.UserDao;
import domain.User;
import mybatis.SqlSession.SqlSession;
import mybatis.SqlSession.SqlSessionFactory;
import mybatis.SqlSession.SqlSessionFactoryBuilder;
import mybatis.io.Resources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    private InputStream is;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void findAllTest() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
