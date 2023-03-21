package com.bank.account.controller;

import com.bank.account.dto.AuditDto;
import com.bank.account.exception.NoSuchInfoException;
import com.bank.account.service.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
@AllArgsConstructor
public class RESTAuditController {
    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AuditDto>> getAllAudit() {
        return new ResponseEntity<>(auditService.getAllAudit(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditDto> getAudit(@PathVariable("id") long id) {
        if (auditService.getAuditById(id) == null) {
            throw new NoSuchInfoException("Audit not found!");
        }
        return new ResponseEntity<>(auditService.getAuditById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AuditDto> saveAudit(@RequestBody AuditDto auditDto) {
        return new ResponseEntity<>(auditService.saveAudit(auditDto), HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<AuditDto> updateAudit(@RequestBody AuditDto auditDto) {
        return new ResponseEntity<>(auditService.updateAudit(auditDto, auditDto.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAudit(@PathVariable("id") long id) {
        auditService.deleteAudit(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
