package com.test.controllers;

import com.test.dto.CustomerDTO;
import com.test.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController
{
    @Autowired
    ICustomerService customerService;

    @PutMapping("/add")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        customerService.saveNewCustomer(customerDTO);
        return "Saved";
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    @GetMapping("/blocked")
    public List<CustomerDTO> getBlockedCustomers()
    {
        return customerService.getBlockedCustomers();
    }
}
