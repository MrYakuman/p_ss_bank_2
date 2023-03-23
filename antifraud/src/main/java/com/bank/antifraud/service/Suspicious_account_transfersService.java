package com.bank.antifraud.service;


import com.bank.antifraud.entity.Suspicious_account_transfers;

import java.util.List;
import java.util.Optional;

public interface Suspicious_account_transfersService {

    void addSuspicious_account_transfers(Suspicious_account_transfers suspicious_account_transfers);

    void updateSuspicious_account_transfers(Long id, Suspicious_account_transfers suspicious_account_transfers);

    void removeSuspicious_account_transfersById(long id);

    List<Suspicious_account_transfers> getAllSuspicious_account_transfers();

    Suspicious_account_transfers findSuspicious_account_transfersById(Long id);
}
