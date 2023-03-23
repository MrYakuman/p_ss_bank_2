package com.bank.antifraud.service;


import com.bank.antifraud.entity.SuspiciousAccountTransfers;

import java.util.List;
import java.util.Optional;

public interface SuspiciousAccountTransfersService {

    void addSuspiciousAccountTransfers(SuspiciousAccountTransfers suspiciousAccountTransfers);

    void updateSuspiciousAccountTransfers(Long id, SuspiciousAccountTransfers suspiciousAccountTransfers);

    void removeSuspiciousAccountTransfersById(long id);

    List<SuspiciousAccountTransfers> getAllSuspiciousAccountTransfers();

    SuspiciousAccountTransfers findSuspiciousAccountTransfersById(long id);
}
