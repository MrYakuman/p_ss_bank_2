package com.bank.transfer.service;

import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.repository.AccountTransferRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountTransferServiceImplTest {
    private static final Long ID = 1L;
    private static final Long ACCOUNT_NUMBER = 123L;

    private static AccountTransfer transfer;
    private static List<AccountTransfer> transfers;

    @Mock
    private AccountTransferRepository repository;

    @InjectMocks
    private AccountTransferServiceImpl service;


    @BeforeAll
    static void init() {
        transfer = AccountTransfer.builder()
                .id(ID)
                .amount(BigDecimal.valueOf(11.11))
                .purpose("test")
                .accountDetailsId(11L)
                .accountNumber(11L)
                .build();
        transfers = List.of(new AccountTransfer(), new AccountTransfer());
    }


    @Test
    void getById_shouldCallFindByIdFromRepository_whenCallGetByIdFromService() {
        when(repository.findById(ID)).thenReturn(Optional.of(transfer));
        var expected = Optional.of(transfer);

        var actual = service.getById(ID);

        verify(repository, times(1)).findById(ID);
        assertThat(actual).isEqualTo(expected); // assertEquals(expected, actual);
    }


    @Test
    void getAll_shouldCallFindAllFromFromRepository_whenCallGetAllFromService() {
        when(repository.findAll()).thenReturn(transfers);
        var expected = transfers;

        var actual = service.getAll();

        verify(repository, times(1)).findAll();
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    void save_shouldCallSaveFromRepository_whenCallSaveFromService() {
        var transfer = new AccountTransfer();

        service.save(transfer);

        verify(repository, times(1)).save(transfer);
    }


    @Test
    void update_shouldCallSaveFromRepository_whenCallUpdateFromService() {
        var transfer = new AccountTransfer();

        service.update(ID, transfer);

        verify(repository, times(1)).save(transfer);
    }


    @Test
    void delete_shouldCallDeleteFromRepository_whenCallDeleteFromService() {
        service.delete(ID);

        verify(repository, times(1)).deleteById(ID);
    }


    @Test
    void getByNumber_shouldCallGetByAccountNumberFromRepository_whenCallGetByNumberFromService() {
        when(repository.getByAccountNumber(ACCOUNT_NUMBER)).thenReturn(Optional.of(transfer));
        var expected = Optional.of(transfer);

        var actual = service.getByNumber(ACCOUNT_NUMBER);

        verify(repository, times(1)).getByAccountNumber(ACCOUNT_NUMBER);
        assertThat(actual).isEqualTo(expected);
    }

}
