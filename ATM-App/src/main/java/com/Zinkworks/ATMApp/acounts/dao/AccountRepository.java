package com.Zinkworks.ATMApp.acounts.dao;

import com.Zinkworks.ATMApp.acounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber and a.pinNumber = :pinNumber")
    Account findAccountByNumberAndPin(Integer accountNumber, int pinNumber);
}
