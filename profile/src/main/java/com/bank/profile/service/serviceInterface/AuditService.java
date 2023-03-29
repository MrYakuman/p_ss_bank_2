package com.bank.profile.service.serviceInterface;

import com.bank.profile.entity.audit.Audit;

import java.util.List;

public interface AuditService {
    boolean saveAudit(Audit audit);

    Audit findAuditById(long auditId);

    List<Audit> getAllAudit();
}
