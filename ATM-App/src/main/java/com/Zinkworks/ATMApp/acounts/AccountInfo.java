package com.Zinkworks.ATMApp.acounts;

public class AccountInfo {
    private Integer accountNumber;
    private Double openingBalance;
    private Double overdraft;


    public AccountInfo(Integer accountNumber, Double openingBalance, Double overdraft) {
        this.accountNumber = accountNumber;
        this.openingBalance = openingBalance;
        this.overdraft = overdraft;

    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public Double getOverdraft() {
        return overdraft;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "accountNumber=" + accountNumber +
                ", openingBalance=" + openingBalance +
                ", overdraft=" + overdraft +
                '}';
    }
}
