package dao;

import domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    List<Account> findByUid(int uid);
}