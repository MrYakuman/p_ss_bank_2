package com.bank.antifraud.service;

import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {
    private final AuditRepository auditRepository;

    @Autowired
    @Lazy
    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public void addAudit(Audit audit) {
        auditRepository.save(audit);
    }

    @Override
    public void updateAudit(Long id, Audit audit) {
        auditRepository.saveAndFlush(audit);
    }

    @Override
    public void removeAuditById(long id) {
        auditRepository.deleteById(id);
    }

    @Override
    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    @Override
    public Audit findAuditById(long id) {
        return auditRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
