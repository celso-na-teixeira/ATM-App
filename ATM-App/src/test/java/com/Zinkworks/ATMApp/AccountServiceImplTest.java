package com.Zinkworks.ATMApp;

import com.Zinkworks.ATMApp.acounts.Account;
import com.Zinkworks.ATMApp.acounts.AccountResult;
import com.Zinkworks.ATMApp.acounts.dao.AccountRepository;
import com.Zinkworks.ATMApp.service.AccountService;
import com.Zinkworks.ATMApp.service.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class AccountServiceImplTest {

    @MockBean
    private AccountRepository accountRepository;

    @InjectMocks
    private final AccountServiceImpl accountService;

    public AccountServiceImplTest(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Test
    public void login(){
        int accountNumb = 123456789;
        int pin = 1234;
        Account account = new Account(123456789, 1234, 1350d, 200d,new java.util.Date());
      //  Mockito.when(accountRepository.findAccountByNumberAndPin(accountNumb, pin)).thenReturn(account);

       // verify(accountService).login(accountNumb,pin);
    }

    @Test
    public void testWithdraw(){

        AccountResult accountResult = accountService.withdraw(10);
    }
}
