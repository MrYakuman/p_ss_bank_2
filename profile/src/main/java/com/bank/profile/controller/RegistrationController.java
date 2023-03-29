package com.bank.profile.controller;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.exception.ArgumentNotValidException;
import com.bank.profile.mappers.RegistrationMapper;
import com.bank.profile.service.serviceInterface.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/registrations")
@Tag(name = "RegistrationController", description = "REST контролер для сущности Registration (адрес регистрации по паспорту).")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    @Operation(
            summary = "Получение всех объектов Registration в формате RegistrationDTO.",
            description = "Получение всех объектов RegistrationDTO. В методе через stream.api каждый объект Registration приводится к RegistrationDTO."
    )
    public ResponseEntity<List<RegistrationDTO>> getAllRegistration() {
        List<RegistrationDTO> allRegistrationDTO;

        allRegistrationDTO = registrationService
                .getAllRegistration()
                .stream()
                .map(RegistrationMapper.INSTANCE::toRegistrationDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allRegistrationDTO, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получение конкретного объекта Registration в формате RegistrationDTO, через его id.",
            description = "Получение объекта RegistrationDTO через registration.id."
    )
    public ResponseEntity<RegistrationDTO> getRegistration(@PathVariable Long id) {
        RegistrationDTO registrationDTO = RegistrationMapper
                .INSTANCE
                .toRegistrationDTO(registrationService.findRegistrationById(id));

        return new ResponseEntity<>(registrationDTO, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление существующего объекта Registration.",
            description = "Обновление существующего объекта Registration."
    )
    public ResponseEntity<RegistrationDTO> editRegistration(@PathVariable Long id,
                                                            @RequestBody @Valid RegistrationDTO registrationDTO,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }

        registrationService.editRegistration(id,
                RegistrationMapper.INSTANCE.toRegistration(registrationDTO));

        return new ResponseEntity<>(registrationDTO, HttpStatus.OK);
    }
}
