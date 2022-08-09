package com.test.dto;

public class AccountDTO
{
    private Long id;
    private Long customerID;
    private long balance;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(Long customerID)
    {
        this.customerID = customerID;
    }
}
