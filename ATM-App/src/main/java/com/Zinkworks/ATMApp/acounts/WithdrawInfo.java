package com.Zinkworks.ATMApp.acounts;

public class WithdrawInfo {
    private String notes;
    private AccountInfo accountInfo;
    private Integer amountWithdrawn;

    public WithdrawInfo(String notes, AccountInfo accountInfo, Integer amountWithdrawn) {
        this.notes = notes;
        this.accountInfo = accountInfo;
        this.amountWithdrawn = amountWithdrawn;
    }

    public String getNotes() {
        return notes;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public Integer getAmountWithdrawn() {
        return amountWithdrawn;
    }

    @Override
    public String toString() {
        return "WithdrawInfo{" +
                "notes='" + notes + '\'' +
                ", accountInfo=" + accountInfo +
                ", amountWithdrawn=" + amountWithdrawn +
                '}';
    }
}
