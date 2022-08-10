package com.test.service.impl;

import com.test.dto.CustomerDTO;
import com.test.entities.Customer;
import com.test.repository.CustomerRepository;
import com.test.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService
{
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;


    public void saveNewCustomer(CustomerDTO customerDTO)
    {
        Customer customerEntity = modelMapper.map(customerDTO,Customer.class);
        customerRepository.save(customerEntity);
    }

    @Override
    public List<CustomerDTO> getBlockedCustomers()
    {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        List<CustomerDTO> resultCustomers = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.set(2001, Calendar.AUGUST,9);

        Date dueDate = c.getTime();

        for(Customer customer : customers)
        {
            if(customer.getBirthDate().after(dueDate))
            {
                CustomerDTO customerDTO = new CustomerDTO();

                customerDTO.setId(customer.getId());
                customerDTO.setCustomerType(customer.getCustomerType());
                customerDTO.setBirthDate(customer.getBirthDate());
                customerDTO.setAddress(customer.getAddress());
                customerDTO.setPhone(customer.getPhone());
                customerDTO.setFirstName(customer.getFirstName());
                customerDTO.setLastName(customer.getLastName());

                resultCustomers.add(customerDTO);
            }
        }
        return resultCustomers;
    }

    @Override
    public List<CustomerDTO> getAllCustomers()
    {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        customers.forEach(customer ->
        {
            customerDTOS.add(modelMapper.map(customer,CustomerDTO.class));
        });

        return customerDTOS;
    }
}
