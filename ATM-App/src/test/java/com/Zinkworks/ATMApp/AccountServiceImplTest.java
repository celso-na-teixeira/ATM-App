package com.Zinkworks.ATMApp;

import com.Zinkworks.ATMApp.acounts.Account;
import com.Zinkworks.ATMApp.acounts.AccountInfo;
import com.Zinkworks.ATMApp.acounts.AccountResult;
import com.Zinkworks.ATMApp.acounts.WithdrawInfo;
import com.Zinkworks.ATMApp.acounts.dao.AccountRepository;
import com.Zinkworks.ATMApp.service.AccountServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
    @Mock
    private AccountRepository accountRepository;

    @Captor
    private ArgumentCaptor<Account> accountArgumentCaptor;
    private AutoCloseable autoCloseable;
    private AccountServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new AccountServiceImpl(accountRepository);
    }


    @Test
    public void testLoginIsSuccessful(){
        int accountNumb = 123456789;
        int pin = 1234;
        Account account = new Account(123456789, 1234, 1350d, 200d,new java.util.Date());
        given(accountRepository.findAccountByNumberAndPin(accountNumb,pin))
                .willReturn(account);
        underTest.login(accountNumb,pin);
        verify(accountRepository).findAccountByNumberAndPin(accountNumb,pin);

    }


    @Test
    @Disabled
    public void testWithdrawLoginSuccessful(){

    }

    @Test
    public void testCheckBalance(){

    }

    @Test
    public void testLoginFail(){
        int accountNumb = 123456789;
        int pin = 000;
        Account account = new Account(123456789, 1234, 1350d, 200d,new java.util.Date());
        given(accountRepository.findAccountByNumberAndPin(accountNumb,pin))
                .willReturn(null);
        underTest.login(accountNumb,pin);
        verify(accountRepository).findAccountByNumberAndPin(accountNumb,pin);
    }


}
