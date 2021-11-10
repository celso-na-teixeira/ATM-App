package com.Zinkworks.ATMApp.acounts;

public final class AccountSession {
    private static AccountSession accountSession;
    public Account account;

    private AccountSession(Account account) {
        this.account = account;
    }

    public static AccountSession startSession(Account account) {
        if (accountSession == null) {
            accountSession = new AccountSession(account);
        }
        return accountSession;
    }

    public static AccountSession endSession(){
        return null;
    }
}
