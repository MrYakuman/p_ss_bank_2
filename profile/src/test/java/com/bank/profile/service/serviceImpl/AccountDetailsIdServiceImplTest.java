package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.repository.AccountDetailsIdRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    void saveAccountDetailsIdShouldReturnTrueTest() {
        doReturn(getAccountDetailsId()).when(accountDetailsIdRepository).save(getAccountDetailsId());

        boolean b = accountDetailsIdServiceImpl.saveAccountDetailsId(getAccountDetailsId());

        verify(accountDetailsIdServiceImpl).saveAccountDetailsId(any(AccountDetailsId.class));
        Assertions.assertTrue(b);
        log.info("test saveAccountDetailsIdShouldReturnTrue completed successfully");
    }

    @Test
    void findAccountDetailsIdByIdShouldReturnAccountDetailsIdTest() {
        doReturn(Optional.of(getAccountDetailsId())).when(accountDetailsIdRepository).findById(anyLong());

        AccountDetailsId accountDetailsId = accountDetailsIdServiceImpl.findAccountDetailsIdById(anyLong());

        verify(accountDetailsIdServiceImpl).findAccountDetailsIdById(anyLong());
        Assertions.assertEquals(getAccountDetailsId(), accountDetailsId);
        log.info("test findAccountDetailsIdByIdShouldReturnAccountDetailsId completed successfully");
    }

    @Test
    void editAccountDetailsIdShouldReturnUpdateAccountDetailsIdTest() {
        doReturn(getAccountDetailsId()).when(accountDetailsIdRepository).save(any(AccountDetailsId.class));

        boolean b = accountDetailsIdServiceImpl.editAccountDetailsId(getAccountDetailsId().getId(), getAccountDetailsId());

        Assertions.assertTrue(b);
        verify(accountDetailsIdServiceImpl).editAccountDetailsId(anyLong(), any(AccountDetailsId.class));
        log.info("test editAccountDetailsIdShouldReturnUpdateAccountDetailsId completed successfully");
    }

    @Test
    void deleteAccountDetailsIdShouldNothingReturnTest() {
        doNothing().when(accountDetailsIdRepository).deleteById(anyLong());

        Assertions.assertTrue(accountDetailsIdServiceImpl.deleteAccountDetailsId(anyLong()));
        verify(accountDetailsIdServiceImpl).deleteAccountDetailsId(anyLong());
        log.info("test deleteAccountDetailsIdShouldNothingReturn completed successfully");
    }

    @Test
    void getAllAccountDetailsIdShouldReturnListTest() {
        List<AccountDetailsId> accountDetailsIds = new ArrayList<>();
        accountDetailsIds.add(mock(AccountDetailsId.class));
        accountDetailsIds.add(mock(AccountDetailsId.class));
        accountDetailsIds.add(mock(AccountDetailsId.class));
        doReturn(accountDetailsIds).when(accountDetailsIdRepository).findAll();

        List<AccountDetailsId> accountDetailsIdExtend = accountDetailsIdServiceImpl.getAllAccountDetailsId();

        Assertions.assertEquals(3, accountDetailsIdExtend.size());
        verify(accountDetailsIdServiceImpl).getAllAccountDetailsId();
        log.info("test getAllAccountDetailsIdShouldReturnList completed successfully");
    }
}