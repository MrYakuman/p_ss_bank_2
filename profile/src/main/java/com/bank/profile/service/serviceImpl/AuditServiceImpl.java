package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.entity.audit.Audit;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.AuditRepository;
import com.bank.profile.service.serviceInterface.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuditServiceImpl implements AuditService {
    private final AuditRepository auditRepository;

    @Autowired
    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public boolean saveAudit(Audit audit) {
        log.info("attempt to save Audit");
        auditRepository.save(audit);
        log.info("saved Audit successfully: id = {}", audit.getId());
        return true;
    }

    @Override
    public Audit findAuditById(long auditId) {
        log.info("attempt to find Audit: id = {}", auditId);
        Audit audit = auditRepository.findById(auditId)
                .orElseThrow(() -> new EntityNotFoundException(Audit.class.getSimpleName(), auditId));
        log.info("Audit found: id = {}", auditId);

        return audit;
    }

    @Override
    public List<Audit> getAllAudit() {
        log.info("attempt to find all Audit");
        var allAudit = auditRepository.findAll();

        if (allAudit.isEmpty()) {
            throw new EntityNotFoundException(Audit.class.getSimpleName());
        }

        log.info("found all Audit successfully, size = {}", allAudit.size());

        return allAudit;
    }
}
