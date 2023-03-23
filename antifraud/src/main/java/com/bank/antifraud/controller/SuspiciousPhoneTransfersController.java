package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousPhoneTransfersDTO;
import com.bank.antifraud.exception.NoSuchSuspiciousAccountTransfersException;
import com.bank.antifraud.exception.NoSuchSuspiciousPhoneTransfersException;
import com.bank.antifraud.mapper.SuspiciousPhoneTransfersMapper;
import com.bank.antifraud.service.SuspiciousPhoneTransfersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/suspicious_phone_transferses")
public class SuspiciousPhoneTransfersController {
    private final SuspiciousPhoneTransfersService suspiciousPhoneTransfersService;

    public SuspiciousPhoneTransfersController(SuspiciousPhoneTransfersService suspiciousPhoneTransfersService) {
        this.suspiciousPhoneTransfersService = suspiciousPhoneTransfersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<SuspiciousPhoneTransfersDTO>> getAllSuspiciousPhoneTransfers() {
        List<SuspiciousPhoneTransfersDTO> allSuspiciousPhoneTransfersDTO;

        allSuspiciousPhoneTransfersDTO = suspiciousPhoneTransfersService
                .getAllSuspiciousPhoneTransfers()
                .stream()
                .map(SuspiciousPhoneTransfersMapper.MAPPER::toSuspiciousPhoneTransfersDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allSuspiciousPhoneTransfersDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuspiciousPhoneTransfersDTO> getSuspiciousPhoneTransfers(@PathVariable Long id) {
        SuspiciousPhoneTransfersDTO suspiciousPhoneTransfersDTO = SuspiciousPhoneTransfersMapper
                .MAPPER
                .toSuspiciousPhoneTransfersDTO(suspiciousPhoneTransfersService.findSuspiciousPhoneTransfersById(id));
        if (suspiciousPhoneTransfersDTO == null) {
            throw new NoSuchSuspiciousPhoneTransfersException("There is no suspiciousPhoneTransfers with ID = " + id + " int Database");
        }

        return new ResponseEntity<>(suspiciousPhoneTransfersDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SuspiciousPhoneTransfersDTO> addNewSuspiciousPhoneTransfers(@RequestBody SuspiciousPhoneTransfersDTO suspiciousPhoneTransfersDTO) {
        suspiciousPhoneTransfersService.addSuspiciousPhoneTransfers(SuspiciousPhoneTransfersMapper.MAPPER.toSuspiciousPhoneTransfers(suspiciousPhoneTransfersDTO));
        return new ResponseEntity<>(suspiciousPhoneTransfersDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuspiciousPhoneTransfersDTO> updateSuspiciousPhoneTransfers(@PathVariable Long id,
                                                                                      @RequestBody SuspiciousPhoneTransfersDTO suspiciousPhoneTransfersDTO) {
        suspiciousPhoneTransfersService.updateSuspiciousPhoneTransfers(id,
                SuspiciousPhoneTransfersMapper.MAPPER.toSuspiciousPhoneTransfers(suspiciousPhoneTransfersDTO));

        return new ResponseEntity<>(suspiciousPhoneTransfersDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSuspiciousPhoneTransfers(@PathVariable Long id) {
        suspiciousPhoneTransfersService.removeSuspiciousPhoneTransfersById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

