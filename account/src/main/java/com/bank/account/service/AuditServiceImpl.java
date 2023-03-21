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
    @Transactional
    public List<AuditDto> getAllAudit() {
        return auditRepository.findAll().stream()
                .map((auditInfo) -> MAPPER.mapToAuditDto(auditInfo))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AuditDto saveAudit(AuditDto auditDto) {
        var audit = MAPPER.mapToAudit(auditDto);
        var savedAudit = auditRepository.save(audit);
        return MAPPER.mapToAuditDto(savedAudit);
    }

    @Override
    @Transactional
    public AuditDto getAuditById(long id) {
        var audit = auditRepository.findById(id);
        return audit.isPresent() ? MAPPER.mapToAuditDto(audit.get()): null;
    }

    @Override
    @Transactional
    public void deleteAudit(long id) {
        var deleteAudit = auditRepository.findById(id);
        if (deleteAudit.isPresent()) {
            auditRepository.deleteById(id);
        } else {
            throw new NoSuchInfoException("Audit not found!");
        }

    }

    @Override
    @Transactional
    public AuditDto updateAudit(AuditDto auditDto, Long id) {
        Audit auditToUpdate = auditRepository.getById(auditDto.getId());
        auditToUpdate.setId(auditDto.getId());
        auditToUpdate.setEntity_type(auditDto.getEntity_type());
        auditToUpdate.setOperation_type(auditDto.getOperation_type());
        auditToUpdate.setCreated_by(auditDto.getCreated_by());
        auditToUpdate.setModified_by(auditDto.getModified_by());
        auditToUpdate.setCreated_by(auditDto.getCreated_by());
        auditToUpdate.setModified_by(auditDto.getModified_by());
        auditToUpdate.setNew_entity_json(auditDto.getNew_entity_json());
        auditToUpdate.setEntity_json(auditDto.getEntity_json());
        return MAPPER.mapToAuditDto(auditToUpdate);
    }
}
