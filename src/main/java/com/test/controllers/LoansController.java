package com.test.controllers;

import com.test.dto.Loan;
import com.test.persitence.CustomerDAO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoansController
{
    @PostMapping("loans/create")
    public String createLoanProposal(@RequestBody Loan loan)
    {
        CustomerDAO customerDao = new CustomerDAO();
        if(customerDao.createLoanProposal(loan))
            return "ok";
        return "failure";
    }
}
