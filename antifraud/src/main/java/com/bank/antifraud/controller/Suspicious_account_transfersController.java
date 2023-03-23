package com.bank.antifraud.controller;

import com.bank.antifraud.dto.Suspicious_account_transfersDTO;
import com.bank.antifraud.mapper.Suspicious_account_transfersMapper;
import com.bank.antifraud.service.Suspicious_account_transfersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/suspicious_account_transferses")
public class Suspicious_account_transfersController {
    private final Suspicious_account_transfersService suspicious_account_transfersService;

    public Suspicious_account_transfersController(Suspicious_account_transfersService suspicious_account_transfersService) {
        this.suspicious_account_transfersService = suspicious_account_transfersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Suspicious_account_transfersDTO>> getAllSuspicious_account_transfers() {
        List<Suspicious_account_transfersDTO> allSuspicious_account_transfersDTO;

        allSuspicious_account_transfersDTO = suspicious_account_transfersService
                .getAllSuspicious_account_transfers()
                .stream()
                .map(Suspicious_account_transfersMapper.MAPPER::toSuspicious_account_transfersDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allSuspicious_account_transfersDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suspicious_account_transfersDTO> getSuspicious_account_transfers(@PathVariable Long id) {
        Suspicious_account_transfersDTO suspicious_account_transfersDTO = Suspicious_account_transfersMapper
                .MAPPER
                .toSuspicious_account_transfersDTO(suspicious_account_transfersService.findSuspicious_account_transfersById(id));

        return new ResponseEntity<>(suspicious_account_transfersDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Suspicious_account_transfersDTO> addNewSuspicious_account_transfers(@RequestBody Suspicious_account_transfersDTO suspicious_account_transfersDTO) {
        suspicious_account_transfersService.addSuspicious_account_transfers(Suspicious_account_transfersMapper.MAPPER.toSuspicious_account_transfers(suspicious_account_transfersDTO));
        return new ResponseEntity<>(suspicious_account_transfersDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suspicious_account_transfersDTO> updateSuspicious_account_transfers(@PathVariable Long id,
                                                                                              @RequestBody Suspicious_account_transfersDTO suspicious_account_transfersDTO) {
        suspicious_account_transfersService.updateSuspicious_account_transfers(id,
                Suspicious_account_transfersMapper.MAPPER.toSuspicious_account_transfers(suspicious_account_transfersDTO));

        return new ResponseEntity<>(suspicious_account_transfersDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSuspicious_account_transfers(@PathVariable Long id) {
        suspicious_account_transfersService.removeSuspicious_account_transfersById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
