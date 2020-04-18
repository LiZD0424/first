import dao.AccountDao;
import dao.UserDao;
import domain.Account;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class ZhuJieTest {
    InputStream is;
    SqlSession sqlSession;
    AccountDao accountDao;
    UserDao userDao;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void findAllTest() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void findByIdTest() {
        User user = new User();
        user.setUsername("gggg");
        user.setId(50);
        userDao.updataById(user);
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }
    }

    @Test
    public void insertUserTest() {
        User user = new User();
        user.setUsername("gggg");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("天津");
        userDao.insertUser(user);
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }
    }

    @Test
    public void deleteUserTest() {
        int id = 51;
        userDao.deleteUser(id);
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }
    }
    @Test
    public void selectByNameTest() {
        String username="%王%";
        List<User> byName = userDao.findByName(username);
        for (User user1 : byName) {
            System.out.println(user1);
        }
    }
    @Test
    public void totalUserTest(){
        System.out.println(userDao.totalUser());
    }
    @Test
    public void findAllAccount(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("---------------------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    @Test
    public void findAllUser(){
        List<User> users = userDao.findAllUser();
        for (User user1 : users) {
            System.out.println(user1);
            System.out.println(user1.getList());
        }
    }
}
