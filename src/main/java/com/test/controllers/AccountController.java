package com.test.controllers;

import com.test.dto.AccountDTO;
import com.test.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController
{

    @Autowired
    IAccountService accountServiceImpl;

    @Autowired
    ModelMapper modelMapper;


    @PutMapping("/add")
    public String saveAccount(@RequestBody AccountDTO accountDTO)
    {
        /*Account accountEntity = new Account();
        accountEntity.setId(accountDTO.getId());
        Optional<Customer> customer = customerRepository.findById(accountDTO.getCustomerID());

        if(customer.isPresent())
        {
            accountEntity.setCustomer(customer.get());
            accountEntity.setBalance(accountDTO.getBalance());
        }

        */
        accountServiceImpl.saveAccount(accountDTO);
        return "Saved";
    }

}
