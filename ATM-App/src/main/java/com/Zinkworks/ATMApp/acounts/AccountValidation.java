package com.Zinkworks.ATMApp.acounts;

import java.util.function.Function;

public interface AccountValidation extends Function<Account, Boolean> {
    Integer MAX_AMOUNT_WITHDRAW = 200;

    static AccountValidation isAmountRequestedBiggerThenBalance(Integer amountRequested) {
        return account -> account.getOpeningBalance() < amountRequested;
    }
    //cannot dispense more funds than customer have access to
    static AccountValidation checkFunds(Integer amountRequested) {
        return account -> account.getOverdraft() < amountRequested;
    }

    static AccountValidation isBiggerThenMaxAmountWithdraw(Integer amountRequested) {
        return account -> amountRequested > MAX_AMOUNT_WITHDRAW;
    }

    default AccountValidation and(AccountValidation other) {
        return account -> this.apply(account) && other.apply(account);
    }
}
