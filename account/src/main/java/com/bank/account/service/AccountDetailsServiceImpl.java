package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetails;
import com.bank.account.exception.NoSuchInfoException;
import com.bank.account.mapper.AutoEntityMapper;
import com.bank.account.repository.AccountDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountDetailsServiceImpl implements AccountDetailsService {
    private final AccountDetailsRepository accountRepository;

    @Override
    @Transactional
    public List<AccountDetailsDto> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map((account) -> AutoEntityMapper.MAPPER.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AccountDetailsDto saveAccount(AccountDetailsDto accountDto) {
        var account = AutoEntityMapper.MAPPER.mapToAccount(accountDto);
        var savedAccount = accountRepository.save(account);
        return AutoEntityMapper.MAPPER.mapToAccountDto(savedAccount);
    }

    @Override
    @Transactional
    public AccountDetailsDto getAccountById(long id) {
        var account = accountRepository.findById(id);
       return account.isPresent() ? AutoEntityMapper.MAPPER.mapToAccountDto(account.get()) : null;
    }

    @Override
    @Transactional
    public void deleteAccount(long id) {
        var deleteAccount = accountRepository.findById(id);
        if (deleteAccount.isPresent()) {
            accountRepository.deleteById(id);
        } else {
            throw new NoSuchInfoException("Account not found!");
        }
    }

    @Override
    @Transactional
    public AccountDetailsDto updateAccount(AccountDetailsDto account, Long id) {
        AccountDetails accountToUpdate = accountRepository.getById(account.getId())
        .setId(account.getId())
        .setPassport_id(account.getPassport_id())
        .setAccount_number(account.getAccount_number())
        .setBank_details_id(account.getBank_details_id())
        .setMoney(account.getMoney())
        .setNegative_balance(account.isNegative_balance())
        .setProfile_id(account.getProfile_id());
        return AutoEntityMapper.MAPPER.mapToAccountDto(accountToUpdate);
    }
}
