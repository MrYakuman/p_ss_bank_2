package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.audit.Audit;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.AuditRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class AuditServiceImplTest {
    @InjectMocks
    @Spy
    private AuditServiceImpl auditServiceImpl;

    @Mock
    private AuditRepository auditRepository;

    static Audit getAudit() {
        return new Audit();
    }

    @Test
    void saveAuditShouldReturnTrue() {
        doReturn(getAudit()).when(auditRepository).save(getAudit());

        boolean b = auditServiceImpl.saveAudit(getAudit());

        assertTrue(b);
        verify(auditServiceImpl).saveAudit(any(Audit.class));
        log.info("test saveAuditShouldReturnTrue completed successfully");
    }

    @Test
    void findAuditByIdShouldReturnAudit() {
        doReturn(Optional.of(getAudit())).when(auditRepository).findById(anyLong());

        Audit audit = auditServiceImpl.findAuditById(anyLong());

        assertEquals(getAudit(), audit);
        verify(auditServiceImpl).findAuditById(anyLong());
        log.info("test findAuditByIdShouldReturnAudit completed successfully");
    }

    @Test
    void findAuditByIdShouldReturnError() {
        assertThrows(EntityNotFoundException.class, () -> auditServiceImpl.findAuditById(anyLong()));
        verify(auditServiceImpl).findAuditById(anyLong());
        log.info("test findAuditByIdShouldReturnError completed successfully");
    }

    @Test
    void getAllAuditShouldReturnList() {
        List<Audit> audits = new ArrayList<>();
        audits.add(mock(Audit.class));
        audits.add(mock(Audit.class));
        audits.add(mock(Audit.class));
        doReturn(audits).when(auditRepository).findAll();

        List<Audit> auditExtend = auditServiceImpl.getAllAudit();

        assertEquals(audits.size(), auditExtend.size());
        verify(auditServiceImpl).getAllAudit();
        log.info("test getAllAuditShouldReturnList completed successfully");
    }

    @Test
    void getAllAuditShouldReturnError() {
        List<Audit> audits = new ArrayList<>();
        doReturn(audits).when(auditRepository).findAll();

        assertThrows(EntityNotFoundException.class, () -> auditServiceImpl.getAllAudit());
        verify(auditServiceImpl).getAllAudit();
        log.info("test getAllAuditShouldReturnError completed successfully");
    }
}