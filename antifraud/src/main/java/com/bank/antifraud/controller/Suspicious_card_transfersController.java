package com.bank.antifraud.controller;

import com.bank.antifraud.dto.Suspicious_card_transfersDTO;
import com.bank.antifraud.mapper.Suspicious_card_transfersMapper;
import com.bank.antifraud.service.Suspicious_card_transfersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/suspicious_card_transferses")
public class Suspicious_card_transfersController {
    private final Suspicious_card_transfersService suspicious_card_transfersService;

    public Suspicious_card_transfersController(Suspicious_card_transfersService suspicious_card_transfersService) {
        this.suspicious_card_transfersService = suspicious_card_transfersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Suspicious_card_transfersDTO>> getAllSuspicious_card_transfers() {
        List<Suspicious_card_transfersDTO> allSuspicious_card_transfersDTO;

        allSuspicious_card_transfersDTO = suspicious_card_transfersService
                .getAllSuspicious_card_transfers()
                .stream()
                .map(Suspicious_card_transfersMapper.MAPPER::toSuspicious_card_transfersDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allSuspicious_card_transfersDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suspicious_card_transfersDTO> getSuspicious_card_transfers(@PathVariable Long id) {
        Suspicious_card_transfersDTO suspicious_card_transfersDTO = Suspicious_card_transfersMapper
                .MAPPER
                .toSuspicious_card_transfersDTO(suspicious_card_transfersService.findSuspicious_card_transfersById(id));

        return new ResponseEntity<>(suspicious_card_transfersDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Suspicious_card_transfersDTO> addNewSuspicious_card_transfers(@RequestBody Suspicious_card_transfersDTO suspicious_card_transfersDTO) {
        suspicious_card_transfersService.addSuspicious_card_transfers(Suspicious_card_transfersMapper.MAPPER.toSuspicious_card_transfers(suspicious_card_transfersDTO));
        return new ResponseEntity<>(suspicious_card_transfersDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suspicious_card_transfersDTO> updateSuspicious_card_transfers(@PathVariable Long id,
                                                                                        @RequestBody Suspicious_card_transfersDTO suspicious_card_transfersDTO) {
        suspicious_card_transfersService.updateSuspicious_card_transfers(id,
                Suspicious_card_transfersMapper.MAPPER.toSuspicious_card_transfers(suspicious_card_transfersDTO));

        return new ResponseEntity<>(suspicious_card_transfersDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSuspicious_card_transfers(@PathVariable Long id) {
        suspicious_card_transfersService.removeSuspicious_card_transfersById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
