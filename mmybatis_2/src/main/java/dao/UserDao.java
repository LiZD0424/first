package dao;


import domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(int id);
    void updataById(User user);
}
