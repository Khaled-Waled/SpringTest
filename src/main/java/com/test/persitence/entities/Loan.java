package com.test.persitence.entities;

import com.test.enums.LoanState;

import javax.persistence.*;
import java.util.Optional;

public class Loan
{
    @Column(name = "amount")
    private long amount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "loan_state")
    @Enumerated(EnumType.STRING)
    private LoanState loanState;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LoanState getLoanState() {
        return loanState;
    }

    public void setLoanState(LoanState loanState) {
        this.loanState = loanState;
    }
}
