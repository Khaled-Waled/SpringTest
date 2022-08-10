package com.test.controllers;

import com.test.dto.AccountDTO;
import com.test.persitence.AccountDAO;
import com.test.entities.Account;
import com.test.entities.Customer;
import com.test.repository.AccountRepository;
import com.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController
{
    @Autowired
    AccountDAO accountDAO;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;


    @PutMapping("/add")
    public String saveAccount(@RequestBody AccountDTO accountDTO)
    {
        //accountDAO.insert(accountDTO);

        Account accountEntity = new Account();
        accountEntity.setId(accountDTO.getId());
        Optional<Customer> customer = customerRepository.findById(accountDTO.getCustomerID());

        if(customer.isPresent())
        {
            accountEntity.setCustomer(customer.get());
            accountEntity.setBalance(accountDTO.getBalance());
        }


        accountRepository.save(accountEntity);
        return "Saved";
    }


    /*@GetMapping("/balance/{id}")
    public ResponseEntity<?> getBalance(@PathVariable int id)
    {
        List<AccountDTO> result = accountDAO.retrieve("id = "+id);
        if (result.isEmpty())
            return ResponseEntity.ok("Customer not found");

        return ResponseEntity.ok(result.get(0).getBalance());
    }*/

}
