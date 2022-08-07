package com.test.controllers;

import com.test.dto.AccountDTO;
import com.test.persitence.AccountDAO;
import com.test.persitence.entities.Account;
import com.test.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController
{
    @Autowired
    AccountDAO accountDAO;

    @Autowired
    AccountRepository accountRepository;


    @PutMapping("/account/add")
    public String saveAccount(@RequestBody AccountDTO accountDTO)
    {
        //accountDAO.insert(accountDTO);

        Account accountEntity = new Account();
        accountEntity.setId((long)accountDTO.getId());
        //accountEntity.setCustomer();
        accountEntity.setBalance(accountDTO.getBalance());

        accountRepository.save(accountEntity);
        return "Saved";
    }


    @GetMapping("/account/balance/{id}")
    public ResponseEntity<?> getBalance(@PathVariable int id)
    {
        List<AccountDTO> result = accountDAO.retrieve("id = "+id);
        if (result.isEmpty())
            return ResponseEntity.ok("Customer not found");

        return ResponseEntity.ok(result.get(0).getBalance());
    }

}
