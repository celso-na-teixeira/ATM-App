package com.Zinkworks.ATMApp.acounts.exceptions;

public class AccountWithdrawException extends Exception{
    public AccountWithdrawException() {
        super();
    }

    public AccountWithdrawException(String message) {
        super(message);
    }

    public AccountWithdrawException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountWithdrawException(Throwable cause) {
        super(cause);
    }

    protected AccountWithdrawException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
