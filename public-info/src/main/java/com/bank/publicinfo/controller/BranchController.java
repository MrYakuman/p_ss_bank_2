package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BankDetailsDTO;
import com.bank.publicinfo.dto.BranchDTO;
import com.bank.publicinfo.entity.Branch;
import com.bank.publicinfo.exception.*;
import com.bank.publicinfo.mapper.BranchMapper;
import com.bank.publicinfo.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private BranchService branchService;

    private BranchMapper branchMapper;

    public BranchController(BranchService branchService, BranchMapper branchMapper) {
        this.branchService = branchService;
        this.branchMapper = branchMapper;
    }


    @GetMapping("/all")
    public ResponseEntity<List<BranchDTO>> getAllBranch() {
        return ResponseEntity.ok(branchService.getAllBranch().stream()
                .map(a -> branchMapper.toBranchDTO(a)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getBranchById(@PathVariable("id") long id) {
        if (branchService.getBranchById(id) == null) {
            throw new BranchNotFoundException("Branch with this id  wasn't found");
        }
        return ResponseEntity.ok(branchMapper.toBranchDTO(branchService.getBranchById(id)));
    }

    @PostMapping
    public ResponseEntity<BranchDTO> postBranch(@RequestBody @Valid BranchDTO branchDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                stringBuilder.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage()).append(";");
            }
            throw new BranchNotCreatedException(stringBuilder.toString());
        }


        return ResponseEntity.ok(
                branchMapper.toBranchDTO(
                        branchService.save(
                                branchMapper.toBranch(branchDTO)
                        )
                )
        );
    }



    @PutMapping
    public ResponseEntity<BranchDTO> putBranch(@RequestBody  @Valid BranchDTO branchDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                stringBuilder.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage()).append(";");
            }
            throw new BranchNotUpdatedException(stringBuilder.toString());
        }
        return ResponseEntity.ok(
                branchMapper.toBranchDTO(
                        branchService.save(
                                branchMapper.toBranch(branchDTO)
                        )
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BranchDTO> deleteBranchById(@PathVariable("id") long id) {
        if (branchService.getBranchById(id) == null) {
            throw new BranchNotFoundException("Branch with this id wasn't found");
        }
        BranchDTO res = branchMapper.toBranchDTO(branchService.getBranchById(id));
        branchService.deleteBranchById(id);
        return ResponseEntity.ok(res);
    }
}
