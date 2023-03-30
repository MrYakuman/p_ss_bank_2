package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousCardTransfersDTO;
import com.bank.antifraud.exception.NoSuchSuspiciousAccountTransfersException;
import com.bank.antifraud.exception.NoSuchSuspiciousCardTransfersException;
import com.bank.antifraud.mapper.SuspiciousCardTransfersMapper;
import com.bank.antifraud.service.SuspiciousCardTransfersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/suspicious_card_transferses")
public class SuspiciousCardTransfersController {
    private final SuspiciousCardTransfersService suspiciousCardTransfersService;

    public SuspiciousCardTransfersController(SuspiciousCardTransfersService suspiciousCardTransfersService) {
        this.suspiciousCardTransfersService = suspiciousCardTransfersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<SuspiciousCardTransfersDTO>> getAllSuspiciousCardTransfers() {
        List<SuspiciousCardTransfersDTO> allSuspiciousCardTransfersDTO;

        allSuspiciousCardTransfersDTO = suspiciousCardTransfersService
                .getAllSuspiciousCardTransfers()
                .stream()
                .map(SuspiciousCardTransfersMapper.MAPPER::toSuspiciousCardTransfersDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allSuspiciousCardTransfersDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuspiciousCardTransfersDTO> getSuspiciousCardTransfers(@PathVariable Long id) {
        SuspiciousCardTransfersDTO suspiciousCardTransfersDTO = SuspiciousCardTransfersMapper
                .MAPPER
                .toSuspiciousCardTransfersDTO(suspiciousCardTransfersService.findSuspiciousCardTransfersById(id));
        if (suspiciousCardTransfersDTO == null) {
            throw new NoSuchSuspiciousCardTransfersException("There is no suspiciousCardTransfers with ID = " + id + " int Database");
        }

        return new ResponseEntity<>(suspiciousCardTransfersDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SuspiciousCardTransfersDTO> addNewSuspiciousCardTransfers(@RequestBody SuspiciousCardTransfersDTO suspiciousCardTransfersDTO) {
        suspiciousCardTransfersService.addSuspiciousCardTransfers(SuspiciousCardTransfersMapper.MAPPER.toSuspiciousCardTransfers(suspiciousCardTransfersDTO));
        return new ResponseEntity<>(suspiciousCardTransfersDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuspiciousCardTransfersDTO> updateSuspiciousCardTransfers(@PathVariable Long id,
                                                                                    @RequestBody SuspiciousCardTransfersDTO suspiciousCardTransfersDTO) {
        suspiciousCardTransfersService.updateSuspiciousCardTransfers(id,
                SuspiciousCardTransfersMapper.MAPPER.toSuspiciousCardTransfers(suspiciousCardTransfersDTO));

        return new ResponseEntity<>(suspiciousCardTransfersDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSuspiciousCardTransfers(@PathVariable Long id) {
        suspiciousCardTransfersService.removeSuspiciousCardTransfersById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

