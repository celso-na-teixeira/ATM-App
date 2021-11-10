package com.Zinkworks.ATMApp.controller;

import com.Zinkworks.ATMApp.acounts.AccountInfo;
import com.Zinkworks.ATMApp.acounts.AccountResult;
import com.Zinkworks.ATMApp.acounts.WithdrawInfo;
import com.Zinkworks.ATMApp.acounts.exceptions.AccountWithdrawException;
import com.Zinkworks.ATMApp.acounts.exceptions.InsufficientFundException;
import com.Zinkworks.ATMApp.acounts.exceptions.SessionException;
import com.Zinkworks.ATMApp.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/atmapp/api/acounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login/{number}/{pin}")
    void login(@PathVariable("number") Integer accountNumber, @PathVariable("pin") Integer pin){
        accountService.login(accountNumber,pin);
    }

    @GetMapping("/withdraw/{amount}")
    AccountResult withdraw(@PathVariable("amount") Integer amount) {
        return accountService.withdraw(amount);
    }

    @GetMapping("/checkBalance")
    AccountResult checkBalance() {
        return accountService.checkBalance();
    }

    @GetMapping("/cancel")
    void cancel(){
        accountService.logout();
    }


}
