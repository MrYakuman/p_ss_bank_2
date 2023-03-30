package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BankDetailsDTO;
import com.bank.publicinfo.exception.*;
import com.bank.publicinfo.mapper.AtmMapper;
import com.bank.publicinfo.mapper.BankDetailsMapper;
import com.bank.publicinfo.service.BankDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bank-details")
public class BankDetailsController {

    private BankDetailsService bankDetailsService;


    private BankDetailsMapper bankDetailsMapper;

    public BankDetailsController(BankDetailsService bankDetailsService, BankDetailsMapper bankDetailsMapper) {
        this.bankDetailsService = bankDetailsService;
        this.bankDetailsMapper = bankDetailsMapper;
    }


    @GetMapping("/all")
    public ResponseEntity<List<BankDetailsDTO>> getAllBankDetails() {
        return ResponseEntity.ok(bankDetailsService.getAllBankDetails().stream()
                .map(a -> bankDetailsMapper.convertToBankDetailsDTO(a)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDetailsDTO> getAtmById(@PathVariable("id") long id) {
        if (bankDetailsService.getBankDetailsById(id) == null) {
            throw new BankDetailsNotFoundException("BankDetails with this id  wasn't found");
        }
        return ResponseEntity.ok(bankDetailsMapper.convertToBankDetailsDTO(bankDetailsService.getBankDetailsById(id)));
    }

    @PostMapping
    public ResponseEntity<BankDetailsDTO> postAtm(@RequestBody @Valid BankDetailsDTO bankDetailsDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                stringBuilder.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage()).append(";");
            }
            throw new BankDetailsNotCreatedException(stringBuilder.toString());
        }


        return ResponseEntity.ok(
                bankDetailsMapper.convertToBankDetailsDTO(
                        bankDetailsService.save(
                                bankDetailsMapper.convertToBankDetails(bankDetailsDTO)
                        )
                )
        );
    }



    @PutMapping
    public ResponseEntity<BankDetailsDTO> putAtm(@RequestBody  @Valid BankDetailsDTO bankDetailsDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                stringBuilder.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage()).append(";");
            }
            throw new BankDetailsNotUpdatedException(stringBuilder.toString());
        }
        return ResponseEntity.ok(
                bankDetailsMapper.convertToBankDetailsDTO(
                        bankDetailsService.save(
                                bankDetailsMapper.convertToBankDetails(bankDetailsDTO)
                        )
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BankDetailsDTO> deleteAtmById(@PathVariable("id") long id) {
        if (bankDetailsService.getBankDetailsById(id) == null) {
            throw new BankDetailsNotFoundException("BankDetails with this id wasn't found");
        }
        BankDetailsDTO res = bankDetailsMapper.convertToBankDetailsDTO(bankDetailsService.getBankDetailsById(id));
        bankDetailsService.deleteBankDetailsById(id);
        return ResponseEntity.ok(res);
    }

}
