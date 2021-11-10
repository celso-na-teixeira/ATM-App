package com.Zinkworks.ATMApp.service;

import com.Zinkworks.ATMApp.acounts.*;
import com.Zinkworks.ATMApp.acounts.dao.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.Zinkworks.ATMApp.acounts.AccountValidation.*;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;
    private AccountSession accountSession;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void login(Integer accountNumber, Integer pin) {
        log.info("Start Login");
        Account account = accountRepository.findAccountByNumberAndPin(accountNumber, pin);
        if (account != null) {
            accountSession = AccountSession.startSession(account);
            log.info("Login successful", account);
        } else {
            log.info("Login fail");
        }
    }

    @Override
    public AccountResult withdraw(Integer amount) {
        WithdrawInfo withdrawInfo = null;
        AccountResult accountResult = new AccountResult();
        ArrayList<String> msg = new ArrayList<>();
        if (accountSession == null || accountSession.account == null) {
            msg.add("Authentication failed");
            accountResult.setErrList(msg);
            return accountResult;
        }
        try {
            Account account = accountRepository.getById(accountSession.account.getId());

            if (isAmountRequestedBiggerThenBalance(amount).apply(account)) {
                msg.add("Cannot dispense more money than it holds");
                accountResult.setErrList(msg);
                return accountResult;
            } else if (isBiggerThenMaxAmountWithdraw(amount).apply(account)) {
                msg.add("The value is higher than allowed");
                accountResult.setErrList(msg);
                return accountResult;
            }
            double newOpenBalance = account.getOpeningBalance() - amount;
            account.setOpeningBalance(newOpenBalance);
            accountRepository.save(account);
            withdrawInfo = new WithdrawInfo(countNotes(amount), (AccountInfo) checkBalance().getObj(), -amount);
            accountResult.setObj(withdrawInfo);
        } catch (Exception aex) {
            log.error(aex.getMessage(), aex.getCause());
        }
        return accountResult;
    }

    @Override
    public AccountResult checkBalance() {
        AccountResult accountResult = new AccountResult();
        AccountInfo accountInfo = null;
        ArrayList<String> msg = new ArrayList<>();
        if (accountSession == null || accountSession.account == null) {
            msg.add("Authentication failed");
            accountResult.setErrList(msg);
            return accountResult;
        }
        try {
            Account account = accountRepository.getById(accountSession.account.getId());
            accountInfo = new AccountInfo(
                    account.getAccountNumber(), account.getOpeningBalance(), account.getOverdraft()
            );
            accountResult.setObj(accountInfo);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex.getCause());
        }

        return accountResult;
    }

    @Override
    public void logout() {
        if (accountSession != null)
            accountSession = AccountSession.endSession();
        log.info("Logout");
    }

    public String countNotes(int amount) {
        StringBuilder str = new StringBuilder();
        int[] notes = new int[]{50, 20, 10, 5};
        int[] noteCounter = new int[4];

        for (int i = 0; i < 4; i++) {
            if (amount >= notes[i]) {
                noteCounter[i] = amount / notes[i];
                amount = amount - noteCounter[i] * notes[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (noteCounter[i] != 0) {
                str.append(noteCounter[i]).append(" x €").append(notes[i]).append("s ");
            }
        }
        return str.toString();
    }
}
