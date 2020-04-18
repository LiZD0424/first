package dao;

import domain.QueryVo;
import domain.Role;
import domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    List<Integer> findUserByName(String name);
    int countUser();
    List<User> findByQueryVo(QueryVo vo);
    List<User> findByCondition(User user);
    List<User> findByIdList(QueryVo vo);
    List<User> findAccount();
    List<User> findRole();
}
