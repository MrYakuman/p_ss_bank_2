package com.bank.antifraud.repository;

import com.bank.antifraud.entity.Suspicious_account_transfers;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface Suspicious_account_transfersRepository extends JpaRepository<Suspicious_account_transfers, Long> {
    Suspicious_account_transfers findById();
}
