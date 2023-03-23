package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousPhoneTransfers;
import com.bank.antifraud.repository.SuspiciousPhoneTransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SuspiciousPhoneTransfersServiceImpl implements SuspiciousPhoneTransfersService {
    private final SuspiciousPhoneTransfersRepository suspiciousPhoneTransfersRepository;

    @Autowired
    public SuspiciousPhoneTransfersServiceImpl(SuspiciousPhoneTransfersRepository suspiciousPhoneTransfersRepository) {
        this.suspiciousPhoneTransfersRepository = suspiciousPhoneTransfersRepository;
    }

    @Override
    @Transactional
    public void addSuspiciousPhoneTransfers(SuspiciousPhoneTransfers suspiciousPhoneTransfers) {
        suspiciousPhoneTransfersRepository.save(suspiciousPhoneTransfers);
    }

    @Override
    @Transactional
    public void updateSuspiciousPhoneTransfers(Long id, SuspiciousPhoneTransfers suspiciousPhoneTransfers) {
        suspiciousPhoneTransfersRepository.saveAndFlush(suspiciousPhoneTransfers);
    }

    @Override
    @Transactional
    public void removeSuspiciousPhoneTransfersById(long id) {
        suspiciousPhoneTransfersRepository.deleteById(id);
    }

    @Override
    public List<SuspiciousPhoneTransfers> getAllSuspiciousPhoneTransfers() {
        return suspiciousPhoneTransfersRepository.findAll();
    }

    @Override
    public SuspiciousPhoneTransfers findSuspiciousPhoneTransfersById(long id) {
        return suspiciousPhoneTransfersRepository.findById(id).orElseThrow(NullPointerException::new);
    }

}
