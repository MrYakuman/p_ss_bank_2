package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.AccountDetailsIdRepository;
import com.bank.profile.service.serviceInterface.AccountDetailsIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountDetailsIdServiceImpl implements AccountDetailsIdService {
    private final AccountDetailsIdRepository accountDetailsIdRepository;

    @Autowired
    public AccountDetailsIdServiceImpl(AccountDetailsIdRepository accountDetailsIdRepository) {
        this.accountDetailsIdRepository = accountDetailsIdRepository;
    }

    @Override
    public boolean saveAccountDetailsId(AccountDetailsId accountDetailsId) {
        log.info("attempt to save AccountDetailsId");
        accountDetailsIdRepository.save(accountDetailsId);
        log.info("saved AccountDetailsId successfully: id = {}", accountDetailsId.getId());
        return true;
    }

    @Override
    public AccountDetailsId findAccountDetailsIdById(long accountDetailsIdId) {
        log.info("attempt to find AccountDetailsId: id = {}", accountDetailsIdId);
        AccountDetailsId accountDetailsId = accountDetailsIdRepository.findById(accountDetailsIdId)
                .orElseThrow(() -> new EntityNotFoundException(AccountDetailsId.class.getSimpleName(), accountDetailsIdId));
        log.info("AccountDetailsId found: id = {}", accountDetailsIdId);

        return accountDetailsId;
    }

    @Override
    public boolean editAccountDetailsId(Long id, AccountDetailsId accountDetailsId) {
        log.info("attempt to update AccountDetailsId: id = {}", id);
        accountDetailsId.setId(id);
        accountDetailsIdRepository.save(accountDetailsId);
        log.info("updated AccountDetailsId successfully: id = {}", id);
        return true;
    }

    @Override
    public boolean deleteAccountDetailsId(long accountDetailsIdId) {
        log.info("attempt to delete AccountDetailsId: {}", accountDetailsIdId);

        try {
            accountDetailsIdRepository.deleteById(accountDetailsIdId);
            log.info("deleted AccountDetailsId successfully: id = {}", accountDetailsIdId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(AccountDetailsId.class.getSimpleName(), accountDetailsIdId, e);
        }
    }

    @Override
    public List<AccountDetailsId> getAllAccountDetailsId() {
        log.info("attempt to find all AccountDetailsId");
        var allAccountDetailsId = accountDetailsIdRepository.findAll();

        if (allAccountDetailsId.isEmpty()) {
            throw new EntityNotFoundException(AccountDetailsId.class.getSimpleName());
        }

        log.info("found all AccountDetailsId successfully, size = {}", allAccountDetailsId.size());

        return allAccountDetailsId;
    }
}
