package com.bank.profile.controller;

import com.bank.profile.dto.AuditDTO;
import com.bank.profile.entity.audit.Audit;
import com.bank.profile.service.serviceInterface.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@Slf4j
class AuditControllerTest {
    @InjectMocks
    private AuditController controller;
    @Mock
    private AuditService service;
    private Long id = 123L;

    static Audit getEntity() {
        return new Audit();
    }

    static AuditDTO getEntityDTO() {
        return new AuditDTO();
    }

    static BindingResult getBindingResult() {
        return mock(BindingResult.class);
    }

    @Test
    void getAllAuditShouldReturnHttpStatusAndListTest() {
        List<Audit> audits = new ArrayList<>();
        audits.add(getEntity());
        audits.add(getEntity());
        audits.add(getEntity());
        doReturn(audits).when(service).getAllAudit();

        ResponseEntity<List<AuditDTO>> response = controller.getAllAudit();

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getAllAuditShouldReturnHttpStatusAndList completed successfully");
    }

    @Test
    void getAuditShouldReturnHttpStatusAndAuditDTO_Test() {
        doReturn(getEntity()).when(service).findAuditById(anyLong());

        ResponseEntity<AuditDTO> response = controller.getAudit(anyLong());

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getRegistrationShouldReturnHttpStatusAndRegistrationDTO completed successfully");
    }

    @Test
    void createAuditShouldReturnHttpStatusAndAuditDTO_Test() {
        ResponseEntity<AuditDTO> response = controller.createAudit(getEntityDTO(), getBindingResult());

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        log.info("test createAuditShouldReturnHttpStatusAndAuditDTO completed successfully");
    }
}