package com.bank.antifraud.repository;

import com.bank.antifraud.entity.Suspicious_phone_transfers;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface Suspicious_phone_transfersRepository extends JpaRepository<Suspicious_phone_transfers, Long> {
    Suspicious_phone_transfers findById();
}
