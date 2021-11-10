package com.Zinkworks.ATMApp.service;

import com.Zinkworks.ATMApp.acounts.AccountInfo;
import com.Zinkworks.ATMApp.acounts.AccountResult;
import com.Zinkworks.ATMApp.acounts.WithdrawInfo;
import com.Zinkworks.ATMApp.acounts.exceptions.AccountWithdrawException;
import com.Zinkworks.ATMApp.acounts.exceptions.SessionException;
import com.Zinkworks.ATMApp.acounts.exceptions.InsufficientFundException;

public interface AccountService {

    void login(Integer accountNumber, Integer pin);

    AccountResult withdraw(Integer amount);

    AccountResult checkBalance();

    void logout();

}
