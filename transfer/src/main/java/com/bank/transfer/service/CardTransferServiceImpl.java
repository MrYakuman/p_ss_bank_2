package com.bank.transfer.service;

import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.repository.CardTransferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@Transactional(readOnly = true)
public class CardTransferServiceImpl implements TransferService<CardTransfer> {

    private final CardTransferRepository repository;

    @Autowired
    public CardTransferServiceImpl(CardTransferRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void save(CardTransfer transfer) {
        log.trace("try to save cardTransfer: {}", transfer);
        repository.save(transfer);
        log.trace("save cardTransfer success, id={}", transfer.getId());
    }

    @Override
    @Transactional
    public void update(Long id, CardTransfer transfer) {
        transfer.setId(id);

        log.trace("try to update cardTransfer: {}", transfer);
        repository.save(transfer);
        log.trace("update cardTransfer success, id={}", transfer.getId());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.trace("try to delete cardTransfer with id={}", id);
        repository.deleteById(id);
        log.trace("success delete cardTransfer with id={}", id);
    }

    @Override
    public Optional<CardTransfer> getById(Long id) {
        log.trace("try to get cardTransfer by id={}", id);
        var transfer = repository.findById(id);
        log.trace("getById cardTransfer success, transfer.isPresent() = {}", transfer.isPresent());

        return transfer;
    }

    @Override
    public Optional<CardTransfer> getByNumber(Long number) {
        log.trace("try to get cardTransfer by cardNumber={}", number);
        var transfer = repository.getByCardNumber(number);
        log.trace("getByNumber cardTransfer success, transfer.isPresent() = {}", transfer.isPresent());

        return transfer;
    }

    @Override
    public List<CardTransfer> getAll() {
        log.trace("try to get All cardTransfers");
        var transfers =repository.findAll();
        log.trace("getAll cardTransfers success, count = {}", transfers.size());

        return transfers;
    }

}
