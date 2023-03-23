package com.bank.antifraud.repository;

import com.bank.antifraud.entity.Suspicious_card_transfers;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface Suspicious_card_transfersRepository extends JpaRepository<Suspicious_card_transfers, Long> {
    Suspicious_card_transfers findById();
}
