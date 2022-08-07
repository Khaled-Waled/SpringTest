package com.test.controllers;

import com.test.dto.CustomerDTO;
import com.test.persitence.CustomerDAO;
import com.test.persitence.entities.Customer;
import com.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CustomerController
{
    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CustomerRepository customerRepository;

    @PutMapping("/customer/add")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        //customerDAO.insert(customerDTO);
        Customer customerEntity = new Customer();
        customerEntity.setFirstName(customerDTO.getfName());
        customerEntity.setLastName(customerDTO.getlName());
        customerEntity.setCustomerType(customerDTO.getCustomerType());
        customerEntity.setBirthDate(customerDTO.getBirthDate());

        customerRepository.save(customerEntity);


        return "Saved";
    }
}
