package com.bank.profile.controller;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.exception.ArgumentNotValidException;
import com.bank.profile.mappers.ActualRegistrationMapper;
import com.bank.profile.service.serviceInterface.ActualRegistrationService;
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
@RequestMapping("/actual_registrations")
@Tag(name = "ActualRegistration", description = "REST контролер для сущности ActualRegistration (адрес фактического проживания).")
public class ActualRegistrationController {

    private final ActualRegistrationService actualRegistrationService;

    @Autowired
    public ActualRegistrationController(ActualRegistrationService actualRegistrationService) {
        this.actualRegistrationService = actualRegistrationService;
    }

    @GetMapping("/")
    @Operation(
            summary = "Получение всех объектов ActualRegistration в формате ActualRegistrationDTO.",
            description = "Получение всех объектов ActualRegistrationDTO. В методе через stream.api каждый объект ActualRegistration приводится к ActualRegistrationDTO."
    )
    public ResponseEntity<List<ActualRegistrationDTO>> getAllActualRegistration() {
        List<ActualRegistrationDTO> allActualRegistrationDTO;

        allActualRegistrationDTO = actualRegistrationService
                .getAllActualRegistration()
                .stream()
                .map(ActualRegistrationMapper.INSTANCE::toActualRegistrationDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allActualRegistrationDTO, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получение конкретного объекта ActualRegistration в формате ActualRegistrationDTO, через его id.",
            description = "Получение объекта ActualRegistrationDTO через actualRegistration.id."
    )
    public ResponseEntity<ActualRegistrationDTO> getActualRegistration(@PathVariable Long id) {
        ActualRegistrationDTO actualRegistrationDTO = ActualRegistrationMapper
                .INSTANCE
                .toActualRegistrationDTO(actualRegistrationService.findActualRegistrationById(id));

        return new ResponseEntity<>(actualRegistrationDTO, HttpStatus.FOUND);
    }


    @PostMapping("/")
    @Operation(
            summary = "Сохранение в бд нового объекта ActualRegistration.",
            description = "Сохранение в бд нового объекта ActualRegistration."
    )
    public ResponseEntity<ActualRegistrationDTO> createActualRegistration(@RequestBody @Valid ActualRegistrationDTO actualRegistrationDTO,
                                                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }

        actualRegistrationService.saveActualRegistration(
                ActualRegistrationMapper.INSTANCE.toActualRegistration(actualRegistrationDTO));

        return new ResponseEntity<>(actualRegistrationDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление существующего объекта ActualRegistration.",
            description = "Обновление существующего объекта ActualRegistration."
    )
    public ResponseEntity<ActualRegistrationDTO> editActualRegistration(@PathVariable Long id,
                                                                        @RequestBody @Valid ActualRegistrationDTO actualRegistrationDTO,
                                                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }

        actualRegistrationService.editActualRegistration(id,
                ActualRegistrationMapper.INSTANCE.toActualRegistration(actualRegistrationDTO));

        return new ResponseEntity<>(actualRegistrationDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление существующего объекта ActualRegistration.",
            description = "Удаление существующего объекта ActualRegistration через actualRegistration.id."
    )
    public ResponseEntity<HttpStatus> deleteActualRegistration(@PathVariable Long id) {
        actualRegistrationService.deleteActualRegistration(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
