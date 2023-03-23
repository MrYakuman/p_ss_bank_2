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
import java.util.stream.Collectors;

import static com.bank.account.mapper.AutoEntityMapper.MAPPER;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RESTAccountController {
    public final String ACCOUNT = AccountDetailsDto.class.getSimpleName().toString().substring(0, 7);
    @NonNull
    private final AccountDetailsService accountService;
    @NonNull
    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AccountDetailsDto>> getAllAccounts() {
        var accounts = accountService.getAllAccounts().stream()
                .map(MAPPER::mapToAccountDto).collect(Collectors.toList());
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDetailsDto> getAccount(@PathVariable("id") long id) {
        var res = accountService.getAccountById(id).orElseThrow(() -> new NoSuchInfoException("Account not found!"));
        return new ResponseEntity<>(MAPPER.mapToAccountDto(res), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AccountDetailsDto> saveAccount(@RequestBody AccountDetailsDto accountDto) throws JsonProcessingException {
        var createAccount = accountService.saveAccount(MAPPER.mapToAccount(accountDto));
        AuditDto auditDto = new AuditDto()
                .setOperation_type("Create")
                .setEntity_type(ACCOUNT)
                .setNew_entity_json(new ObjectMapper().writeValueAsString(createAccount))
                .setEntity_json(new ObjectMapper().writeValueAsString(createAccount));
        auditService.saveAudit(MAPPER.mapToAudit(auditDto));
        return new ResponseEntity<>(MAPPER.mapToAccountDto(createAccount), HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<AccountDetailsDto> updateAccount(@RequestBody AccountDetailsDto accountDto) throws JsonProcessingException {
        AuditDto auditDto = new AuditDto();
        auditDto.setEntity_json(accountService.getAccountById(accountDto.getId())
                .get().toString()); // сохраняем в аудит старый Entity_json
        var updateAccount = accountService.updateAccount(MAPPER.mapToAccount(accountDto));
        auditDto.setOperation_type("Update")
                .setEntity_type(ACCOUNT)
                .setNew_entity_json(new ObjectMapper()
                        .writeValueAsString(updateAccount)); // сохраняем в аудит новый Entity_json
        auditService.saveAudit(MAPPER.mapToAudit(auditDto));
        return new ResponseEntity<>(MAPPER.mapToAccountDto(updateAccount), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) throws JsonProcessingException {
        accountService.deleteAccount(id);
        AuditDto auditDto = new AuditDto()
                .setOperation_type("Delete")
                .setEntity_type(ACCOUNT)
                .setNew_entity_json(null)
                .setEntity_json(new ObjectMapper().writeValueAsString(accountService.getAccountById(id)));
        auditService.saveAudit(MAPPER.mapToAudit(auditDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
