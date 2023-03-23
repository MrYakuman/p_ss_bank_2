package com.bank.antifraud.service;

import com.bank.antifraud.entity.Suspicious_phone_transfers;
import com.bank.antifraud.repository.Suspicious_phone_transfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Suspicious_phone_transfersServiceImpl implements Suspicious_phone_transfersService {
    private final Suspicious_phone_transfersRepository suspicious_phone_transfersRepository;

    @Autowired
    @Lazy
    public Suspicious_phone_transfersServiceImpl(Suspicious_phone_transfersRepository suspicious_phone_transfersRepository) {
        this.suspicious_phone_transfersRepository = suspicious_phone_transfersRepository;
    }

    @Override
    @Transactional
    public void addSuspicious_phone_transfers(Suspicious_phone_transfers suspicious_phone_transfers) {
        suspicious_phone_transfersRepository.save(suspicious_phone_transfers);
    }

    @Override
    public void updateSuspicious_phone_transfers(Long id, Suspicious_phone_transfers suspicious_phone_transfers) {
        suspicious_phone_transfersRepository.saveAndFlush(suspicious_phone_transfers);
    }

    @Override
    public void removeSuspicious_phone_transfersById(long id) {
        suspicious_phone_transfersRepository.deleteById(id);
    }

    @Override
    public List<Suspicious_phone_transfers> getAllSuspicious_phone_transfers() {
        return suspicious_phone_transfersRepository.findAll();
    }

    @Override
    public Suspicious_phone_transfers findSuspicious_phone_transfersById(long id) {
        return suspicious_phone_transfersRepository.findById(id).orElseThrow(NullPointerException::new);
    }

}
