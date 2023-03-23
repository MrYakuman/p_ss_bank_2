package com.bank.antifraud.service;

import com.bank.antifraud.entity.Suspicious_phone_transfers;

import java.util.List;
import java.util.Optional;

public interface Suspicious_phone_transfersService {

    void addSuspicious_phone_transfers(Suspicious_phone_transfers suspicious_phone_transfers);

    void updateSuspicious_phone_transfers(Long id, Suspicious_phone_transfers suspicious_phone_transfers);

    void removeSuspicious_phone_transfersById(long id);

    List<Suspicious_phone_transfers> getAllSuspicious_phone_transfers();

    Suspicious_phone_transfers findSuspicious_phone_transfersById(long id);
}
