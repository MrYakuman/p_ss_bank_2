package com.bank.antifraud.service;

import com.bank.antifraud.entity.Suspicious_account_transfers;
import com.bank.antifraud.repository.Suspicious_account_transfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Suspicious_account_transfersServiceImpl implements Suspicious_account_transfersService{
    private final Suspicious_account_transfersRepository suspicious_account_transfersRepository;

    @Autowired
    @Lazy
    public Suspicious_account_transfersServiceImpl(Suspicious_account_transfersRepository suspicious_account_transfersRepository) {
        this.suspicious_account_transfersRepository = suspicious_account_transfersRepository;
    }

    @Override
    public void addSuspicious_account_transfers(Suspicious_account_transfers suspicious_account_transfers) {
        suspicious_account_transfersRepository.save(suspicious_account_transfers);
    }

    @Override
    public void updateSuspicious_account_transfers(Long id, Suspicious_account_transfers suspicious_account_transfers) {
        suspicious_account_transfersRepository.saveAndFlush(suspicious_account_transfers);
    }

    @Override
    public void removeSuspicious_account_transfersById(long id) {
        suspicious_account_transfersRepository.deleteById(id);
    }

    @Override
    public List<Suspicious_account_transfers> getAllSuspicious_account_transfers() {
        return suspicious_account_transfersRepository.findAll();
    }

    @Override
    public Suspicious_account_transfers findSuspicious_account_transfersById(Long id) {
        return suspicious_account_transfersRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
