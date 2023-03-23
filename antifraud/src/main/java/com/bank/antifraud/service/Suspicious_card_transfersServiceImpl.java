package com.bank.antifraud.service;

import com.bank.antifraud.entity.Suspicious_card_transfers;
import com.bank.antifraud.repository.Suspicious_card_transfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Suspicious_card_transfersServiceImpl implements Suspicious_card_transfersService {
    private final Suspicious_card_transfersRepository suspicious_card_transfersRepository;

    @Autowired
    @Lazy
    public Suspicious_card_transfersServiceImpl(Suspicious_card_transfersRepository suspicious_card_transfersRepository) {
        this.suspicious_card_transfersRepository = suspicious_card_transfersRepository;
    }

    @Override
    public void addSuspicious_card_transfers(Suspicious_card_transfers suspicious_card_transfers) {
        suspicious_card_transfersRepository.save(suspicious_card_transfers);
    }

    @Override
    public void updateSuspicious_card_transfers(Long id, Suspicious_card_transfers suspicious_card_transfers) {
        suspicious_card_transfersRepository.saveAndFlush(suspicious_card_transfers);
    }

    @Override
    public void removeSuspicious_card_transfersById(long id) {
        suspicious_card_transfersRepository.deleteById(id);
    }

    @Override
    public List<Suspicious_card_transfers> getAllSuspicious_card_transfers() {
        return suspicious_card_transfersRepository.findAll();
    }

    @Override
    public Suspicious_card_transfers findSuspicious_card_transfersById(long id) {
        return suspicious_card_transfersRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
