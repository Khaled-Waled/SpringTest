package com.test.dto;

//enum LoanState {PENDING, ACCEPTED, REJECTED};
public class Loan
{
    private int accountId;
    private long amount;
    private String loanState;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getLoanState() {
        return loanState;
    }

    public void setLoanState(String loanState) {
        this.loanState = loanState;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }


}
