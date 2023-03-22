package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetails;
import com.bank.account.exception.NoSuchInfoException;
import com.bank.account.repository.AccountDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountDetailsServiceImpl implements AccountDetailsService {
    private final AccountDetailsRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AccountDetails> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public AccountDetails saveAccount(AccountDetails account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AccountDetails> getAccountById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteAccount(long id) {
        accountRepository.findById(id).orElseThrow(() -> new NoSuchInfoException("Account not found!"));
        accountRepository.deleteById(id);
    }

    @Override
    @Transactional
    public AccountDetails updateAccount(AccountDetails account) {
        AccountDetails accountToUpdate = accountRepository.getById(account.getId())
                .setId(account.getId())
                .setPassport_id(account.getPassport_id())
                .setAccount_number(account.getAccount_number())
                .setBank_details_id(account.getBank_details_id())
                .setMoney(account.getMoney())
                .setNegative_balance(account.isNegative_balance())
                .setProfile_id(account.getProfile_id());
        return accountToUpdate;
    }
}
