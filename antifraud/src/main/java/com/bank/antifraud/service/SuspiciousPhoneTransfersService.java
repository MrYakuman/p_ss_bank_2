package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousPhoneTransfers;

import java.util.List;

public interface SuspiciousPhoneTransfersService {

    void addSuspiciousPhoneTransfers(SuspiciousPhoneTransfers suspiciousPhoneTransfers);

    void updateSuspiciousPhoneTransfers(Long id, SuspiciousPhoneTransfers suspiciousPhoneTransfers);

    void removeSuspiciousPhoneTransfersById(long id);

    List<SuspiciousPhoneTransfers> getAllSuspiciousPhoneTransfers();

    SuspiciousPhoneTransfers findSuspiciousPhoneTransfersById(long id);
}
