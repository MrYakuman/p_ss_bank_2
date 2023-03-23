package com.bank.antifraud.controller;

import com.bank.antifraud.dto.AuditDTO;
import com.bank.antifraud.mapper.AuditMapper;
import com.bank.antifraud.service.AuditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/audits")
public class AuditController {
    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AuditDTO>> getAllAudits() {
        List<AuditDTO> allAuditDTO;

        allAuditDTO = auditService
                .getAllAudits()
                .stream()
                .map(AuditMapper.MAPPER::toAuditDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allAuditDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditDTO> getAudit(@PathVariable Long id) {
        AuditDTO auditDTO = AuditMapper
                .MAPPER
                .toAuditDTO(auditService.findAuditById(id));

        return new ResponseEntity<>(auditDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<AuditDTO> addNewAudit(@RequestBody AuditDTO auditDTO) {
        auditService.addAudit(AuditMapper.MAPPER.toAudit(auditDTO));
        return new ResponseEntity<>(auditDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditDTO> updateAudit(@PathVariable Long id,
    @RequestBody AuditDTO auditDTO) {
        auditService.updateAudit(id,
                AuditMapper.MAPPER.toAudit(auditDTO));

        return new ResponseEntity<>(auditDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAudit(@PathVariable Long id) {
        auditService.removeAuditById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
