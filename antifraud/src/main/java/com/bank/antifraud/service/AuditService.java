package com.bank.antifraud.service;

import com.bank.antifraud.entity.Audit;

import java.util.List;
import java.util.Optional;

public interface AuditService {

    void addAudit(Audit audit);

    void updateAudit(Long id, Audit audit);

    void removeAuditById(long id);

    List<Audit> getAllAudits();

    Audit findAuditById(long id);
}
