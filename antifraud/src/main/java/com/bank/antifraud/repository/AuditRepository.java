package com.bank.antifraud.repository;

import com.bank.antifraud.entity.Audit;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface AuditRepository extends JpaRepository<Audit, Long> {
    Audit findById();
}
