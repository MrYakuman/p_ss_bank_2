package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.dto.AuditDto;

import java.util.List;

public interface AuditService {
    List<AuditDto> getAllAudit();

    AuditDto saveAudit(AuditDto auditDto);

    AuditDto getAuditById(long id);

    void deleteAudit(long id);

    AuditDto updateAudit(AuditDto auditDto, Long id);
}
