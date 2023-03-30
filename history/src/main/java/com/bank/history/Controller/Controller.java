package com.bank.history.Controller;

import com.bank.history.DTO.HistoryDTO;
import com.bank.history.Service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;


@RestController
@AllArgsConstructor

public class Controller {
    private final HistoryService historyService;

    @GetMapping("/{id}")
    public ResponseEntity<HistoryDTO> getHistoryById(@PathVariable BigInteger id) {
        HistoryDTO historyDTO = historyService.getHistoryById(id);
        return new ResponseEntity<>(historyDTO, HttpStatus.OK);
    }
}

