package com.bank.antifraud.controller;

import com.bank.antifraud.dto.Suspicious_phone_transfersDTO;
import com.bank.antifraud.mapper.Suspicious_phone_transfersMapper;
import com.bank.antifraud.service.Suspicious_phone_transfersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/suspicious_phone_transferses")
public class Suspicious_phone_transfersController {
    private final Suspicious_phone_transfersService suspicious_phone_transfersService;

    public Suspicious_phone_transfersController(Suspicious_phone_transfersService suspicious_phone_transfersService) {
        this.suspicious_phone_transfersService = suspicious_phone_transfersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Suspicious_phone_transfersDTO>> getAllSuspicious_phone_transfers() {
        List<Suspicious_phone_transfersDTO> allSuspicious_phone_transfersDTO;

        allSuspicious_phone_transfersDTO = suspicious_phone_transfersService
                .getAllSuspicious_phone_transfers()
                .stream()
                .map(Suspicious_phone_transfersMapper.MAPPER::toSuspicious_phone_transfersDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allSuspicious_phone_transfersDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suspicious_phone_transfersDTO> getSuspicious_phone_transfers(@PathVariable Long id) {
        Suspicious_phone_transfersDTO suspicious_phone_transfersDTO = Suspicious_phone_transfersMapper
                .MAPPER
                .toSuspicious_phone_transfersDTO(suspicious_phone_transfersService.findSuspicious_phone_transfersById(id));

        return new ResponseEntity<>(suspicious_phone_transfersDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Suspicious_phone_transfersDTO> addNewSuspicious_phone_transfers(@RequestBody Suspicious_phone_transfersDTO suspicious_phone_transfersDTO) {
        suspicious_phone_transfersService.addSuspicious_phone_transfers(Suspicious_phone_transfersMapper.MAPPER.toSuspicious_phone_transfers(suspicious_phone_transfersDTO));
        return new ResponseEntity<>(suspicious_phone_transfersDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suspicious_phone_transfersDTO> updateSuspicious_phone_transfers(@PathVariable Long id,
                                                                                          @RequestBody Suspicious_phone_transfersDTO suspicious_phone_transfersDTO) {
        suspicious_phone_transfersService.updateSuspicious_phone_transfers(id,
                Suspicious_phone_transfersMapper.MAPPER.toSuspicious_phone_transfers(suspicious_phone_transfersDTO));

        return new ResponseEntity<>(suspicious_phone_transfersDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSuspicious_phone_transfers(@PathVariable Long id) {
        suspicious_phone_transfersService.removeSuspicious_phone_transfersById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
