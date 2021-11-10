package com.Zinkworks.ATMApp;

import com.Zinkworks.ATMApp.acounts.Account;
import org.junit.jupiter.api.Test;

import static com.Zinkworks.ATMApp.acounts.AccountValidation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountValidationTest {
    @Test
    public void testIsAmountRequestedBiggerThenBalance(){
        Account account = new Account(123456789, 1234, 150d, 200d,new java.util.Date());
        assertEquals(Boolean.TRUE,isAmountRequestedBiggerThenBalance(350).apply(account));
    }
    @Test
    public void testIsAmountRequestedSmallerThenBalance(){
        Account account = new Account(123456789, 1234, 1350d, 200d,new java.util.Date());
        assertEquals(Boolean.FALSE,isAmountRequestedBiggerThenBalance(350).apply(account));
    }

    @Test
    public void testisBiggerThenMaxAmountWithdraw(){
        Account account = new Account(123456789, 1234, 1350d, 200d,new java.util.Date());
        assertEquals(Boolean.TRUE,isBiggerThenMaxAmountWithdraw(201).apply(account));
    }

    @Test
    public void testisSmallerThenMaxAmountWithdraw(){
        Account account = new Account(123456789, 1234, 1350d, 200d,new java.util.Date());
        assertEquals(Boolean.FALSE,isBiggerThenMaxAmountWithdraw(200).apply(account));
    }

    @Test
    public void testCheckFundsSmaller(){
        Account account = new Account(123456789, 1234, 1350d, 200d,new java.util.Date());
        assertEquals(Boolean.TRUE,checkFunds(210).apply(account));
    }

    @Test
    public void testCheckFundsBigger(){
        Account account = new Account(123456789, 1234, 1350d, 200d,new java.util.Date());
        assertEquals(Boolean.FALSE,checkFunds(150).apply(account));
    }

}
