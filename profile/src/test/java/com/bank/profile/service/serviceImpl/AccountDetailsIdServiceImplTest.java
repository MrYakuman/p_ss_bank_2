package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.AccountDetailsIdRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class AccountDetailsIdServiceImplTest {

    @InjectMocks
    @Spy
    private AccountDetailsIdServiceImpl accountDetailsIdServiceImpl;

    @Mock
    private AccountDetailsIdRepository accountDetailsIdRepository;

    static AccountDetailsId getAccountDetailsId() {
        return new AccountDetailsId();
    }

    @Test
    void saveAccountDetailsIdShouldReturnTrue() {
        doReturn(getAccountDetailsId()).when(accountDetailsIdRepository).save(getAccountDetailsId());

        boolean b = accountDetailsIdServiceImpl.saveAccountDetailsId(getAccountDetailsId());

        assertTrue(b);
        verify(accountDetailsIdServiceImpl).saveAccountDetailsId(any(AccountDetailsId.class));
        log.info("test saveAccountDetailsIdShouldReturnTrue completed successfully");
    }

    @Test
    void findAccountDetailsIdByIdShouldReturnAccountDetailsId() {
        doReturn(Optional.of(getAccountDetailsId())).when(accountDetailsIdRepository).findById(anyLong());

        AccountDetailsId accountDetailsId = accountDetailsIdServiceImpl.findAccountDetailsIdById(anyLong());

        assertEquals(getAccountDetailsId(), accountDetailsId);
        verify(accountDetailsIdServiceImpl).findAccountDetailsIdById(anyLong());
        log.info("test findAccountDetailsIdByIdShouldReturnAccountDetailsId completed successfully");
    }

    @Test
    void findAccountDetailsIdByIdShouldReturnError() {
        assertThrows(EntityNotFoundException.class, () -> accountDetailsIdServiceImpl.findAccountDetailsIdById(anyLong()));
        verify(accountDetailsIdServiceImpl).findAccountDetailsIdById(anyLong());
        log.info("test findAccountDetailsIdByIdShouldReturnError completed successfully");
    }

    @Test
    void editAccountDetailsIdShouldReturnUpdateAccountDetailsId() {
        doReturn(getAccountDetailsId()).when(accountDetailsIdRepository).save(any(AccountDetailsId.class));

        boolean b = accountDetailsIdServiceImpl.editAccountDetailsId(getAccountDetailsId().getId(), getAccountDetailsId());

        assertTrue(b);
        verify(accountDetailsIdServiceImpl).editAccountDetailsId(anyLong(), any(AccountDetailsId.class));
        log.info("test editAccountDetailsIdShouldReturnUpdateAccountDetailsId completed successfully");
    }

    @Test
    void deleteAccountDetailsIdShouldCompletedSuccessfully() {
        assertTrue(accountDetailsIdServiceImpl.deleteAccountDetailsId(anyLong()));
        verify(accountDetailsIdServiceImpl).deleteAccountDetailsId(anyLong());
        log.info("test deleteAccountDetailsIdShouldNothingReturn completed successfully");
    }

    @Test
    void deleteAccountDetailsIdShouldReturnError() {
        doThrow(EmptyResultDataAccessException.class).when(accountDetailsIdRepository).deleteById(anyLong());

        assertThrows(EntityNotFoundException.class, () -> accountDetailsIdServiceImpl.deleteAccountDetailsId(anyLong()));
        verify(accountDetailsIdServiceImpl).deleteAccountDetailsId(anyLong());
        log.info("test deleteAccountDetailsIdShouldReturnError completed successfully");
    }

    @Test
    void getAllAccountDetailsIdShouldReturnList() {
        List<AccountDetailsId> accountDetailsIds = new ArrayList<>();
        accountDetailsIds.add(mock(AccountDetailsId.class));
        accountDetailsIds.add(mock(AccountDetailsId.class));
        accountDetailsIds.add(mock(AccountDetailsId.class));
        doReturn(accountDetailsIds).when(accountDetailsIdRepository).findAll();

        List<AccountDetailsId> accountDetailsIdExtend = accountDetailsIdServiceImpl.getAllAccountDetailsId();

        assertEquals(accountDetailsIds.size(), accountDetailsIdExtend.size());
        verify(accountDetailsIdServiceImpl).getAllAccountDetailsId();
        log.info("test getAllAccountDetailsIdShouldReturnList completed successfully");
    }

    @Test
    void getAllAccountDetailsIdShouldReturnError() {
        List<AccountDetailsId> accountDetailsIds = new ArrayList<>();
        doReturn(accountDetailsIds).when(accountDetailsIdRepository).findAll();

        assertThrows(EntityNotFoundException.class, () -> accountDetailsIdServiceImpl.getAllAccountDetailsId());
        verify(accountDetailsIdServiceImpl).getAllAccountDetailsId();
        log.info("test getAllAccountDetailsIdShouldReturnError completed successfully");
    }
}