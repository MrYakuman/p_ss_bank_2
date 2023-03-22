package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetails;

import java.util.List;
import java.util.Optional;

public interface AccountDetailsService {
    List<AccountDetails> getAllAccounts();

    AccountDetails saveAccount(AccountDetails account);

    Optional<AccountDetails> getAccountById(long id);

    void deleteAccount(long id);

    AccountDetails updateAccount(AccountDetails account);
}
