package com.test.controllers;

import com.test.dto.LoanDTO;
import com.test.entities.Account;
import com.test.entities.Loan;
import com.test.repository.AccountRepository;
import com.test.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/loan")
public class LoansController
{
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/create")
    public String createLoanProposal(@RequestBody LoanDTO loanDTO)
    {
        /*CustomerDAO customerDao = new CustomerDAO();
        if(customerDao.createLoanProposal(loanDTO))
            return "ok";
        return "failure";*/

        Loan loanEntity = new Loan();
        Optional<Account> account = accountRepository.findById(loanDTO.getAccountId());
        if(account.isPresent())
        {
            loanEntity.setAccount(account.get());
            loanEntity.setLoanState(loanDTO.getLoanState());
            loanEntity.setAmount(loanDTO.getAmount());
        }

        loanRepository.save(loanEntity);
        return "Saved";
    }
}
