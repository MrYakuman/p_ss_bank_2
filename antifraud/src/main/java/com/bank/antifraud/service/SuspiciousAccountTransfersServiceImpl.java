package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousAccountTransfers;
import com.bank.antifraud.repository.SuspiciousAccountTransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SuspiciousAccountTransfersServiceImpl implements SuspiciousAccountTransfersService {
    private final SuspiciousAccountTransfersRepository suspiciousAccountTransfersRepository;

    @Autowired
    public SuspiciousAccountTransfersServiceImpl(SuspiciousAccountTransfersRepository suspiciousAccountTransfersRepository) {
        this.suspiciousAccountTransfersRepository = suspiciousAccountTransfersRepository;
    }

    @Override
    @Transactional
    public void addSuspiciousAccountTransfers(SuspiciousAccountTransfers suspiciousAccountTransfers) {
        suspiciousAccountTransfersRepository.save(suspiciousAccountTransfers);
    }

    @Override
    @Transactional
    public void updateSuspiciousAccountTransfers(Long id, SuspiciousAccountTransfers suspiciousAccountTransfers) {
        suspiciousAccountTransfersRepository.saveAndFlush(suspiciousAccountTransfers);
    }

    @Override
    @Transactional
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
