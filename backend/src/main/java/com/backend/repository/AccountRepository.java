package com.backend.repository;

import com.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByAccountNumber(String accountNumber);

    List<Account> findAccountsByUserUsername(String loggedInUsername);
}
