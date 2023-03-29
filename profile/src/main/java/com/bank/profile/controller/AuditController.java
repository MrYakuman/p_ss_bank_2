package com.bank.profile.controller;

import com.bank.profile.dto.AuditDTO;
import com.bank.profile.exception.ArgumentNotValidException;
import com.bank.profile.mappers.AuditMapper;
import com.bank.profile.service.serviceInterface.AuditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audits")
@Tag(name = "AuditController", description = "REST контролер для сущности Audit (объект Audit представляет собой запись CRUD операции с основными сущностями).")
public class AuditController {
    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/")
    @Operation(
            summary = "Получение всех объектов Audit в формате AuditDTO.",
            description = "Получение всех объектов AuditDTO. В методе через stream.api каждый объект Audit приводится к AuditDTO."
    )
    public ResponseEntity<List<AuditDTO>> getAllAudit() {
        List<AuditDTO> allAuditDTO;

        allAuditDTO = auditService
                .getAllAudit()
                .stream()
                .map(AuditMapper.INSTANCE::toAuditDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allAuditDTO, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получение конкретного объекта Audit в формате AuditDTO, через его id.",
            description = "Получение объекта AuditDTO через audit.id."
    )
    public ResponseEntity<AuditDTO> getAudit(@PathVariable Long id) {
        AuditDTO auditDTO = AuditMapper
                .INSTANCE
                .toAuditDTO(auditService.findAuditById(id));

        return new ResponseEntity<>(auditDTO, HttpStatus.FOUND);
    }

    @PostMapping("/")
    @Operation(
            summary = "Сохранение в бд нового объекта Audit.",
            description = "Сохранение в бд нового объекта Audit."
    )
    public ResponseEntity<AuditDTO> createAudit(@RequestBody @Valid AuditDTO auditDTO,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }

        auditService.saveAudit(
                AuditMapper.INSTANCE.toAudit(auditDTO));

        return new ResponseEntity<>(auditDTO, HttpStatus.CREATED);
    }

}