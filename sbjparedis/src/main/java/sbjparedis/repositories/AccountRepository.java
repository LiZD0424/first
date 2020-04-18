package sbjparedis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sbjparedis.domain.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Override
    List<Account> findAll();
}
