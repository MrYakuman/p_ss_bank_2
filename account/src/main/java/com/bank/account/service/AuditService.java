package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.dto.AuditDto;
import com.bank.account.entity.audit.Audit;

import java.util.List;
import java.util.Optional;

public interface AuditService {
    List<Audit> getAllAudit();

    Audit saveAudit(Audit audit);

    Optional <Audit> getAuditById(long id);

    void deleteAudit(long id);

    Audit updateAudit(Audit audit);
}
