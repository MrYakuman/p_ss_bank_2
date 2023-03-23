package com.bank.antifraud.service;

import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AuditServiceImpl implements AuditService {
    private final AuditRepository auditRepository;

    @Autowired
    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    @Transactional
    public void addAudit(Audit audit) {
        auditRepository.save(audit);
    }

    @Override
    @Transactional
    public void updateAudit(Long id, Audit audit) {
        auditRepository.saveAndFlush(audit);
    }

    @Override
    @Transactional
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
