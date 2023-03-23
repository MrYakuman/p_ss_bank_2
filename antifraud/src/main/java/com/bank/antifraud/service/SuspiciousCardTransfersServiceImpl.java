package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousCardTransfers;
import com.bank.antifraud.repository.SuspiciousCardTransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuspiciousCardTransfersServiceImpl implements SuspiciousCardTransfersService {
    private final SuspiciousCardTransfersRepository suspiciousCardTransfersRepository;

    @Autowired
    public SuspiciousCardTransfersServiceImpl(SuspiciousCardTransfersRepository suspiciousCardTransfersRepository) {
        this.suspiciousCardTransfersRepository = suspiciousCardTransfersRepository;
    }

    @Override
    public void addSuspiciousCardTransfers(SuspiciousCardTransfers suspiciousCardTransfers) {
        suspiciousCardTransfersRepository.save(suspiciousCardTransfers);
    }

    @Override
    public void updateSuspiciousCardTransfers(Long id, SuspiciousCardTransfers suspiciousCardTransfers) {
        suspiciousCardTransfersRepository.saveAndFlush(suspiciousCardTransfers);
    }

    @Override
    public void removeSuspiciousCardTransfersById(long id) {
        suspiciousCardTransfersRepository.deleteById(id);
    }

    @Override
    public List<SuspiciousCardTransfers> getAllSuspiciousCardTransfers() {
        return suspiciousCardTransfersRepository.findAll();
    }

    @Override
    public SuspiciousCardTransfers findSuspiciousCardTransfersById(long id) {
        return suspiciousCardTransfersRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
