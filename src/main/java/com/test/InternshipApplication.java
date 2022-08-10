package com.test;

import com.test.dto.AccountDTO;
import com.test.entities.Account;
import com.test.entities.Customer;
import com.test.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class InternshipApplication
{
    public static void main(String... args) {
        SpringApplication.run(InternshipApplication.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        /*
        modelMapper.addMappings(new PropertyMap<AccountDTO, Account>() {
            @Override
            protected void configure()
            {
                map().setCustomer(customerRepository.findById(source.getId()).get());
                /*Optional<Customer> customerOptional = customerRepository.findById(source.getId());
                if (customerOptional.isPresent())
                    map().setCustomer(customerOptional.get());
                else
                    map().setCustomer(null);
            }
        });
        */
        return modelMapper;
    }
}