package com.bank.antifraud.service;


import com.bank.antifraud.entity.Suspicious_card_transfers;

import java.util.List;
import java.util.Optional;

public interface Suspicious_card_transfersService {
    void addSuspicious_card_transfers(Suspicious_card_transfers suspicious_card_transfers);

    void updateSuspicious_card_transfers(Long id, Suspicious_card_transfers suspicious_card_transfers);

    void removeSuspicious_card_transfersById(long id);

    List<Suspicious_card_transfers> getAllSuspicious_card_transfers();

    Suspicious_card_transfers findSuspicious_card_transfersById(long id);
}
