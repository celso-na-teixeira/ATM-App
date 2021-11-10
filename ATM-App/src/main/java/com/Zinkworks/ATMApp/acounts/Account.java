package com.Zinkworks.ATMApp.acounts;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

//@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="account_number")
    private Integer accountNumber;
    @Column(name="pin_number")
    private int pinNumber;
    @Column(name="opening_balance")
    private Double openingBalance;
    @Column(name="overdraft")
    private Double overdraft;
    @Column(name="created_on")
    private Date createdOn;
    @Column(name="last_login")
    private Date lastLogin;

    public Account() {
    }

    public Account(Integer accountNumber, int pinNumber, Double openingBalance, Double overdraft, Date createdOn) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.openingBalance = openingBalance;
        this.overdraft = overdraft;
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return pinNumber == account.pinNumber && Objects.equals(id, account.id) && Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, pinNumber);
    }

    public Long getId() {
        return id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public Double getOverdraft() {
        return overdraft;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public void setOverdraft(Double overdraft) {
        this.overdraft = overdraft;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", openingBalance=" + openingBalance +
                ", overdraft=" + overdraft +
                '}';
    }
}
