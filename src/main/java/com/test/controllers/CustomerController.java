package com.test.controllers;

import com.test.dto.CustomerDTO;
import com.test.persitence.CustomerDAO;
import com.test.entities.Customer;
import com.test.repository.CustomerRepository;
import com.test.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController
{
    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ICustomerService customerService;

    @PutMapping("/add")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        //customerDAO.insert(customerDTO);
        Customer customerEntity = new Customer();
        customerEntity.getFromDTO(customerDTO);

        customerRepository.save(customerEntity);
        return "Saved";
    }

    @GetMapping("/blocked")
    public List<CustomerDTO> getBlockedCustomers()
    {
        return customerService.getBlockedCustomers();
    }
}
