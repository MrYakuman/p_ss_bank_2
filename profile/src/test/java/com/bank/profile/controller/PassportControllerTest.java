package com.bank.profile.controller;

import com.bank.profile.dto.PassportDTO;
import com.bank.profile.entity.Passport;
import com.bank.profile.exception.ArgumentNotValidException;
import com.bank.profile.service.serviceInterface.PassportService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@Slf4j
class PassportControllerTest {
    @InjectMocks
    private PassportController controller;
    @Mock
    private PassportService service;
    private Long id = 123L;

    static Passport getEntity() {
        return new Passport();
    }

    static PassportDTO getEntityDTO() {
        return new PassportDTO();
    }

    static BindingResult getBindingResult() {
        return mock(BindingResult.class);
    }

    @Test
    void getAllPassportShouldReturnHttpStatusAndList() {
        List<Passport> passports = new ArrayList<>();
        passports.add(getEntity());
        passports.add(getEntity());
        passports.add(getEntity());
        doReturn(passports).when(service).getAllPassport();

        ResponseEntity<List<PassportDTO>> response = controller.getAllPassport();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getAllPassportShouldReturnHttpStatusAndList completed successfully");
    }

    @Test
    void getPassportShouldReturnHttpStatusAndPassportDTO() {
        doReturn(getEntity()).when(service).findPassportById(anyLong());

        ResponseEntity<PassportDTO> response = controller.getPassport(anyLong());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getRegistrationShouldReturnHttpStatusAndRegistrationDTO completed successfully");
    }

    @Test
    void editPassportShouldReturnHttpStatusAndPassportDTO() {
        ResponseEntity<PassportDTO> response = controller.editPassport(id, getEntityDTO(), getBindingResult());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        log.info("test editPassportShouldReturnHttpStatusAndPassportDTO completed successfully");
    }

    @Test
    void editPassportShouldReturnError() {
        BindingResult bindingResult = getBindingResult();
        doReturn(true).when(bindingResult).hasErrors();

        assertThrows(ArgumentNotValidException.class, () -> controller.editPassport(id, getEntityDTO(), bindingResult));
        log.info("test editPassportShouldReturnError completed successfully");
    }
}