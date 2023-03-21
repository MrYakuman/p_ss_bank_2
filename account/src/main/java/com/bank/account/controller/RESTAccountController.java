package com.bank.account.controller;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.dto.AuditDto;
import com.bank.account.exception.NoSuchInfoException;
import com.bank.account.service.AccountDetailsService;
import com.bank.account.service.AuditService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RESTAccountController {
    public final String ACCOUNT = AccountDetailsDto.class.getSimpleName().toString().substring(0,7);
   @NonNull
    private final AccountDetailsService accountService;
    @NonNull
    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AccountDetailsDto>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDetailsDto> getAccount(@PathVariable("id") long id) {
        if (accountService.getAccountById(id) == null) {
            throw new NoSuchInfoException("Account not found!");
        }
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AccountDetailsDto> saveAccount(@RequestBody AccountDetailsDto accountDto) throws JsonProcessingException {
        var createAccount = accountService.saveAccount(accountDto);
        auditService.saveAudit(new AuditDto()
                .setOperation_type("Create")
                .setEntity_type(ACCOUNT)
                .setNew_entity_json(new ObjectMapper().writeValueAsString(createAccount))
                .setEntity_json(new ObjectMapper().writeValueAsString(createAccount)));
        return new ResponseEntity<>(createAccount, HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<AccountDetailsDto> updateAccount(@RequestBody AccountDetailsDto account) throws JsonProcessingException {
        var updateAccount = accountService.updateAccount(account, account.getId());
        auditService.saveAudit(new AuditDto()
                .setOperation_type("Update")
                .setEntity_type(ACCOUNT)
                .setNew_entity_json(new ObjectMapper().writeValueAsString(updateAccount))
                .setEntity_json(new ObjectMapper().writeValueAsString(account)));
        return new ResponseEntity<>(updateAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) throws JsonProcessingException {
        accountService.deleteAccount(id);
        auditService.saveAudit(new AuditDto()
                .setOperation_type("Delete")
                .setEntity_type(ACCOUNT)
                .setNew_entity_json(null)
                .setEntity_json(new ObjectMapper().writeValueAsString(accountService.getAccountById(id))));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
