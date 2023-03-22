package com.bank.account.service;

import com.bank.account.dto.AuditDto;
import com.bank.account.entity.audit.Audit;
import com.bank.account.exception.NoSuchInfoException;
import com.bank.account.mapper.AutoEntityMapper;
import com.bank.account.repository.AuditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bank.account.mapper.AutoEntityMapper.MAPPER;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService{
    private final AuditRepository auditRepository;
    @Override
    @Transactional (readOnly = true)
    public List<Audit> getAllAudit() {
        return auditRepository.findAll();
    }

    @Override
    @Transactional
    public Audit saveAudit(Audit audit) {
        return auditRepository.save(audit);
    }

    @Override
    @Transactional (readOnly = true)
    public Optional <Audit> getAuditById(long id) {
        return auditRepository.findById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public void deleteAudit(long id) {
       auditRepository.findById(id).orElseThrow(() -> new NoSuchInfoException("Audit not found!"));
            auditRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Audit updateAudit(Audit audit) {
        Audit auditToUpdate = auditRepository.getById(audit.getId());
        auditToUpdate.setId(audit.getId());
        auditToUpdate.setEntity_type(audit.getEntity_type());
        auditToUpdate.setOperation_type(audit.getOperation_type());
        auditToUpdate.setCreated_by(audit.getCreated_by());
        auditToUpdate.setModified_by(audit.getModified_by());
        auditToUpdate.setCreated_by(audit.getCreated_by());
        auditToUpdate.setModified_by(audit.getModified_by());
        auditToUpdate.setNew_entity_json(audit.getNew_entity_json());
        auditToUpdate.setEntity_json(audit.getEntity_json());
        return auditToUpdate;
    }
}
