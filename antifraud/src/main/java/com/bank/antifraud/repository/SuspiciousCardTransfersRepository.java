package com.bank.antifraud.repository;

import com.bank.antifraud.entity.SuspiciousCardTransfers;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspiciousCardTransfersRepository extends JpaRepository<SuspiciousCardTransfers, Long> {
}
