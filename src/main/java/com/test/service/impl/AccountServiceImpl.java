package com.test.service.impl;

import com.test.dto.AccountDTO;
import com.test.entities.Account;
import com.test.repository.AccountRepository;
import com.test.repository.CustomerRepository;
import com.test.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService
{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;
    public void saveAccount(AccountDTO accountDTO)
    {
        Account accountEntity = convertAccountDtoToEntity(accountDTO);
        accountRepository.save(accountEntity);
    }

    public Account convertAccountDtoToEntity(AccountDTO source)
    {
        Account account = modelMapper.map(source, Account.class);
        account.setCustomer(customerRepository.getById(source.getCustomerID()));
        return account;
    }
}
