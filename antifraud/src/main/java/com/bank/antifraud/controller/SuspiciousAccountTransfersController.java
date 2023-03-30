package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousAccountTransfersDTO;
import com.bank.antifraud.exception.NoSuchAuditException;
import com.bank.antifraud.exception.NoSuchSuspiciousAccountTransfersException;
import com.bank.antifraud.mapper.SuspiciousAccountTransfersMapper;
import com.bank.antifraud.service.SuspiciousAccountTransfersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/suspicious_account_transferses")
public class SuspiciousAccountTransfersController {
    private final SuspiciousAccountTransfersService suspiciousAccountTransfersService;

    public SuspiciousAccountTransfersController(SuspiciousAccountTransfersService suspiciousAccountTransfersService) {
        this.suspiciousAccountTransfersService = suspiciousAccountTransfersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<SuspiciousAccountTransfersDTO>> getAllSuspiciousAccountTransfers() {
        List<SuspiciousAccountTransfersDTO> allSuspiciousAccountTransfersDTO;

        allSuspiciousAccountTransfersDTO = suspiciousAccountTransfersService
                .getAllSuspiciousAccountTransfers()
                .stream()
                .map(SuspiciousAccountTransfersMapper.MAPPER::toSuspiciousAccountTransfersDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allSuspiciousAccountTransfersDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuspiciousAccountTransfersDTO> getSuspiciousAccountTransfers(@PathVariable Long id) {
        SuspiciousAccountTransfersDTO suspiciousAccountTransfersDTO = SuspiciousAccountTransfersMapper
                .MAPPER
                .toSuspiciousAccountTransfersDTO(suspiciousAccountTransfersService.findSuspiciousAccountTransfersById(id));
        if (suspiciousAccountTransfersDTO == null) {
            throw new NoSuchSuspiciousAccountTransfersException("There is no suspiciousAccountTransfers with ID = " + id + " int Database");
        }

        return new ResponseEntity<>(suspiciousAccountTransfersDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SuspiciousAccountTransfersDTO> addNewSuspiciousAccountTransfers(@RequestBody SuspiciousAccountTransfersDTO suspiciousAccountTransfersDTO) {
        suspiciousAccountTransfersService.addSuspiciousAccountTransfers(SuspiciousAccountTransfersMapper.MAPPER.toSuspiciousAccountTransfers(suspiciousAccountTransfersDTO));
        return new ResponseEntity<>(suspiciousAccountTransfersDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuspiciousAccountTransfersDTO> updateSuspiciousAccountTransfers(@PathVariable Long id,
                                                                                            @RequestBody SuspiciousAccountTransfersDTO suspiciousAccountTransfersDTO) {
        suspiciousAccountTransfersService.updateSuspiciousAccountTransfers(id,
                SuspiciousAccountTransfersMapper.MAPPER.toSuspiciousAccountTransfers(suspiciousAccountTransfersDTO));

        return new ResponseEntity<>(suspiciousAccountTransfersDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSuspiciousAccountTransfers(@PathVariable Long id) {
        suspiciousAccountTransfersService.removeSuspiciousAccountTransfersById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
