import dao.UserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    InputStream is;
    SqlSession sqlSession;
    UserDao userDao;
    SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession(true);
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
/*        for (User user : users) {
            System.out.println("-----------------------");
            System.out.println(user);
            System.out.println(user.getList());
        }*/
    }

    /**
     * 一级缓存是 SqlSession 范围的缓存，直接缓存对象，第二次查询已有信息时直接返回缓存内对象的引用，两次查询到的其实是同一个对象。当调用 SqlSession 的修改，添加，删除，commit()，close()等方法时就会清空所有一级缓存
     */
    @Test
    public void findByIdTest() {
        User user = userDao.findById(41);
        System.out.println(user);
        user.setUsername("老王");
        user.setId(50);//即使不更改刚才查到的记录，也会重新查询。代表着update方法已经清空了SqlSession的缓存
        userDao.updataById(user);
        User user1 = userDao.findById(41);
        System.out.println(user1);
    }

    @Test
    /**
     * 二级缓存是 factory 范围的缓存，缓存的是数据，第二次查询已有信息时创建新对象并把缓存内数据赋值给它，两次查询到的对象不是同一个，只是数据相同，只有SqlSession关闭后才将数据存入factory提供的二级缓存中，不关闭的话第二次将会重新查询
     */
    public void twoCacheTest() {
        SqlSession sqlSession1 = factory.openSession(true);
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        User user = userDao1.findById(41);
        System.out.println(user);
        sqlSession1.close();

        SqlSession sqlSession2 = factory.openSession(true);
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        User user1 = userDao2.findById(41);
        System.out.println(user1);
        sqlSession2.close();
    }
}
