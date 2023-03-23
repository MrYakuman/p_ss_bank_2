package com.bank.antifraud.service;


import com.bank.antifraud.entity.SuspiciousCardTransfers;

import java.util.List;

public interface SuspiciousCardTransfersService {
    void addSuspiciousCardTransfers(SuspiciousCardTransfers suspiciousCardTransfers);

    void updateSuspiciousCardTransfers(Long id, SuspiciousCardTransfers suspiciousCardTransfers);

    void removeSuspiciousCardTransfersById(long id);

    List<SuspiciousCardTransfers> getAllSuspiciousCardTransfers();

    SuspiciousCardTransfers findSuspiciousCardTransfersById(long id);
}
