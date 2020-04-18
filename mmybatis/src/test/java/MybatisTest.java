import dao.AccountDao;
import dao.RoleDao;
import dao.UserDao;
import domain.Account;
import domain.QueryVo;
import domain.Role;
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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MybatisTest {
    InputStream is;
    SqlSession sqlSession;
    UserDao userDao;
    AccountDao accountDao;
    RoleDao roleDao;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();//openSession()中参数设为true则为自动提交，不需要手动书写sqlSession.commit()
        userDao = sqlSession.getMapper(UserDao.class);
        accountDao=sqlSession.getMapper(AccountDao.class);
        roleDao=sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();//配置事务时用的JDBC，需要手动提交，否则回滚
        sqlSession.close();
        is.close();
    }

    @Test
    public void addUserText() {
        User user=new User();
        user.setBirthday(new Date());
        user.setAddress("天津");
        user.setSex("女");
        user.setUsername("MMMM");
        System.out.println(user);
        userDao.addUser(user);
        System.out.println(user);
    }
    @Test
    public void updateUserText() {
        User user=new User();
        user.setId(41);
        user.setBirthday(new Date());
        user.setSex("女");
        userDao.updateUser(user);
    }
    @Test
    public void deleteUserText() {
        int id=49;
        userDao.deleteUser(id);
    }
    @Test
    public void findUserByNameText() {
        String name ="王";//如果UserDao.xml中用注释的那种就得写%王%
        List<Integer> userByName = userDao.findUserByName(name);
        for (Integer user : userByName) {
            System.out.println(user);
        }
    }
    @Test
    public void countUserText() {
        System.out.println(userDao.countUser());
    }
    @Test
    public void findByQueryVoText() {
        QueryVo queryVo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        queryVo.setS("男");
        List<User> userByName = userDao.findByQueryVo(queryVo);
        for (User u : userByName) {
            System.out.println(u);
        }
    }
    @Test
    public void findByCondition(){
        User user=new User();
        user.setUsername("老王");
        //user.setSex("男");
        List<User> users=userDao.findByCondition(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public void findByListTest(){
        QueryVo vo=new QueryVo();
        List<Integer>list=new LinkedList<Integer>();//只要是list接口实现类就行，foreach都能遍历
        list.add(41);
        list.add(43);
        vo.setIntegers(list);
        List<User> users=userDao.findByIdList(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public void findByListTest1(){
        QueryVo vo=new QueryVo();
        int[]a=new int[]{41,43};//数组也能遍历
        vo.setA(a);
        List<User> users=userDao.findByIdList(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public void findAllAccount(){
        List<Account> list=accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
    @Test
    public void findAccount(){
        List<User> list=userDao.findAccount();
        for (User user : list) {
            System.out.println(user);
            System.out.println(user.getList());
        }
    }
    @Test
    public void findAllTest(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    @Test
    public void findAllRole(){
        List<Role>roles=roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
    @Test
    public void findRole(){
        List<User>roles=userDao.findRole();
        for (User user : roles) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
    public void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3.使用工厂创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession对象创建Dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        is.close();
    }
}
