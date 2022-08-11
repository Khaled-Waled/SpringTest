package com.test.service;

import com.test.dto.AccountDTO;
import com.test.entities.Account;

public interface IAccountService
{
    void saveAccount(AccountDTO accountDTO);
    Account convertAccountDtoToEntity(AccountDTO source);

}
