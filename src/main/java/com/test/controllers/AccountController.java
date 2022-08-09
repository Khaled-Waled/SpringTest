package com.test.controllers;

import com.test.dto.AccountDTO;
import com.test.persitence.AccountDAO;
import com.test.persitence.entities.Account;
import com.test.persitence.entities.Customer;
import com.test.repository.AccountRepository;
import com.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        accountEntity.setCustomer(customer);
        accountEntity.setBalance(accountDTO.getBalance());

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
