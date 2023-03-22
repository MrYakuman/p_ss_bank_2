package com.bank.account.controller;

import com.bank.account.dto.AuditDto;
import com.bank.account.exception.NoSuchInfoException;
import com.bank.account.mapper.AutoEntityMapper;
import com.bank.account.service.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.bank.account.mapper.AutoEntityMapper.MAPPER;

@RestController
@RequestMapping("/audit")
@AllArgsConstructor
public class RESTAuditController {
    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AuditDto>> getAllAudit() {
        var audits = auditService.getAllAudit().stream().map(MAPPER::mapToAuditDto).collect(Collectors.toList());
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditDto> getAudit(@PathVariable("id") long id) {
        var audit = auditService.getAuditById(id).orElseThrow(() -> new NoSuchInfoException("Audit not found!"));
        return new ResponseEntity<>(MAPPER.mapToAuditDto(audit), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AuditDto> saveAudit(@RequestBody AuditDto auditDto) {
        var savedAudit  = auditService.saveAudit(MAPPER.mapToAudit(auditDto));
        return new ResponseEntity<>(MAPPER.mapToAuditDto(savedAudit), HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<AuditDto> updateAudit(@RequestBody AuditDto auditDto) {
        var updatedAudit  = auditService.updateAudit(MAPPER.mapToAudit(auditDto));
        return new ResponseEntity<>(MAPPER.mapToAuditDto(updatedAudit), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAudit(@PathVariable("id") long id) {
        auditService.deleteAudit(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
