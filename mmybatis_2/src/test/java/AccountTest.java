import dao.AccountDao;
import domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    InputStream is;
    SqlSession sqlSession;
    AccountDao accountDao;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void findAllTest(){
        List<Account>accounts=accountDao.findAll();
        //只有全部注释掉才不会查询user
//        for (Account account : accounts) {
//            System.out.println("------------------------");
//            System.out.println(account);
//            System.out.println(account.getUser());
//        }
    }
}
