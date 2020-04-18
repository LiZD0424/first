package sbjparedis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sbjparedis.domain.Account;
import sbjparedis.repositories.AccountRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SbjparedisApplication.class)
public class JPARedisTest {
    @Autowired
    private AccountRepository accountRepository;
    //自动注入spring提供好的Redis模板
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void JpaTest(){
        List<Account> accounts=accountRepository.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void RedisTest() throws JsonProcessingException {
        String accountListJson=redisTemplate.boundValueOps("account.findAll").get();
        if (accountListJson==null){
            List<Account> accounts=accountRepository.findAll();
            ObjectMapper om=new ObjectMapper();
            accountListJson=om.writeValueAsString(accounts);
            //将数据存储到redis中，下次在查询直接从redis中获得数据，不用在查询数据库
            redisTemplate.boundValueOps("account.findAll").set(accountListJson);
            System.out.println("数据库获取");
        }else {
            System.out.println("redis获取");
        }
        System.out.println(accountListJson);
    }
}
