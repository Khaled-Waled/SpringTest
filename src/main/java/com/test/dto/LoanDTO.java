package com.test.dto;

import com.test.enums.LoanState;

//enum LoanState {PENDING, ACCEPTED, REJECTED};
public class LoanDTO
{
    private Long accountId;
    private long amount;
    private LoanState loanState;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public LoanState getLoanState() {
        return loanState;
    }

    public void setLoanState(LoanState loanState) {
        this.loanState = loanState;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }


}
