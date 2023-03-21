package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetails;

import java.util.List;

public interface AccountDetailsService {
    List<AccountDetailsDto> getAllAccounts();

    AccountDetailsDto saveAccount(AccountDetailsDto accountDto);

    AccountDetailsDto getAccountById(long id);

    void deleteAccount(long id);

    AccountDetailsDto updateAccount(AccountDetailsDto account, Long id);
}
