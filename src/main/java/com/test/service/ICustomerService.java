package com.test.service;

import com.test.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService
{
    public List<CustomerDTO> getBlockedCustomers();
    public List<CustomerDTO> getAllCustomers();

    void saveNewCustomer(CustomerDTO customerDTO);
}
