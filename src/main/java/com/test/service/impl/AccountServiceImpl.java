package com.test.service.impl;

import com.test.dto.AccountDTO;
import com.test.entities.Account;
import com.test.repository.AccountRepository;
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
    public void saveAccount(AccountDTO accountDTO)
    {
        Account accountEntity = modelMapper.map(accountDTO, Account.class);
        accountRepository.save(accountEntity);
    }
}
