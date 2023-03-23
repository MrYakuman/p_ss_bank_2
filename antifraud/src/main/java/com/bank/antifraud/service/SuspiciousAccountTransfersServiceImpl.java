package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousAccountTransfers;
import com.bank.antifraud.repository.SuspiciousAccountTransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuspiciousAccountTransfersServiceImpl implements SuspiciousAccountTransfersService {
    private final SuspiciousAccountTransfersRepository suspiciousAccountTransfersRepository;

    @Autowired
    public SuspiciousAccountTransfersServiceImpl(SuspiciousAccountTransfersRepository suspiciousAccountTransfersRepository) {
        this.suspiciousAccountTransfersRepository = suspiciousAccountTransfersRepository;
    }

    @Override
    public void addSuspiciousAccountTransfers(SuspiciousAccountTransfers suspiciousAccountTransfers) {
        suspiciousAccountTransfersRepository.save(suspiciousAccountTransfers);
    }

    @Override
    public void updateSuspiciousAccountTransfers(Long id, SuspiciousAccountTransfers suspiciousAccountTransfers) {
        suspiciousAccountTransfersRepository.saveAndFlush(suspiciousAccountTransfers);
    }

    @Override
    public void removeSuspiciousAccountTransfersById(long id) {
        suspiciousAccountTransfersRepository.deleteById(id);
    }

    @Override
    public List<SuspiciousAccountTransfers> getAllSuspiciousAccountTransfers() {
        return suspiciousAccountTransfersRepository.findAll();
    }

    @Override
    public SuspiciousAccountTransfers findSuspiciousAccountTransfersById(long id) {
        return suspiciousAccountTransfersRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
