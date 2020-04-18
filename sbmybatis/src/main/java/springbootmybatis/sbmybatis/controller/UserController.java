package springbootmybatis.sbmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootmybatis.sbmybatis.Dao.UserDao;
import springbootmybatis.sbmybatis.domain.User;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/query")
    public List<User> findAll(){
        List<User>users=userDao.findAll();
        return users;
    }
}
