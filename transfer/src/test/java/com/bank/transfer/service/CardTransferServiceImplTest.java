package com.bank.transfer.service;

import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.repository.CardTransferRepository;
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
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CardTransferServiceImplTest {
    private static final Long ID = 1L;
    private static final Long CARD_NUMBER = 123L;

    private static CardTransfer transfer;
    private static List<CardTransfer> transfers;

    @Mock
    private CardTransferRepository repository;

    @InjectMocks
    private CardTransferServiceImpl service;


    @BeforeAll
    static void init() {
        transfer = CardTransfer.builder()
                .id(ID)
                .amount(BigDecimal.valueOf(11.11))
                .purpose("test")
                .accountDetailsId(11L)
                .cardNumber(11L)
                .build();
        transfers = List.of(new CardTransfer(), new CardTransfer());
    }


    @Test
    void getById_shouldCallFindByIdFromRepository_whenCallGetByIdFromService() {
        doReturn(Optional.of(transfer)).when(repository).findById(ID);
        var expected = Optional.of(transfer);

        var actual = service.getById(ID);

        verify(repository, times(1)).findById(ID);
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    void getAll_shouldCallFindAllFromFromRepository_whenCallGetAllFromService() {
        doReturn(transfers).when(repository).findAll();
        var expected = transfers;

        var actual = service.getAll();

        verify(repository, times(1)).findAll();
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    void save_shouldCallSaveFromRepository_whenCallSaveFromService() {
        var transfer = new CardTransfer();

        service.save(transfer);

        verify(repository, times(1)).save(transfer);
    }


    @Test
    void update_shouldCallSaveFromRepository_whenCallUpdateFromService() {
        var transfer = new CardTransfer();

        service.update(ID, transfer);

        verify(repository, times(1)).save(transfer);
    }


    @Test
    void delete_shouldCallDeleteFromRepository_whenCallDeleteFromService() {
        service.delete(ID);

        verify(repository, times(1)).deleteById(ID);
    }


    @Test
    void getByNumber_shouldCallGetByCardNumberFromRepository_whenCallGetByNumberFromService() {
        doReturn(Optional.of(transfer)).when(repository).getByCardNumber(CARD_NUMBER);
        var expected = Optional.of(transfer);

        var actual = service.getByNumber(CARD_NUMBER);

        verify(repository, times(1)).getByCardNumber(CARD_NUMBER);
        assertThat(actual).isEqualTo(expected);
    }

}
