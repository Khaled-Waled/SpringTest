package com.test.entities;

import com.test.enums.LoanState;

import javax.persistence.*;

@Table(name = "loans")
@Entity
public class Loan
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    private long amount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "loan_state")
    @Enumerated(EnumType.STRING)
    private LoanState loanState;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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
