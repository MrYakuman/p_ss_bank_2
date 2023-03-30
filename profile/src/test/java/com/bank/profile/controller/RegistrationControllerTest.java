package com.bank.profile.controller;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import com.bank.profile.exception.ArgumentNotValidException;
import com.bank.profile.service.serviceInterface.RegistrationService;
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
class RegistrationControllerTest {
    @InjectMocks
    private RegistrationController controller;

    @Mock
    private RegistrationService service;

    private Long id = 123L;

    static Registration getEntity() {
        return new Registration();
    }

    static RegistrationDTO getEntityDTO() {
        return new RegistrationDTO();
    }

    static BindingResult getBindingResult() {
        return mock(BindingResult.class);
    }

    @Test
    void getAllRegistrationShouldReturnHttpStatusAndList() {
        List<Registration> registrations = new ArrayList<>();
        registrations.add(getEntity());
        registrations.add(getEntity());
        registrations.add(getEntity());
        doReturn(registrations).when(service).getAllRegistration();

        ResponseEntity<List<RegistrationDTO>> response = controller.getAllRegistration();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getAllRegistrationShouldReturnHttpStatusAndList completed successfully");
    }

    @Test
    void getRegistrationShouldReturnHttpStatusAndRegistrationDTO() {
        doReturn(getEntity()).when(service).findRegistrationById(anyLong());

        ResponseEntity<RegistrationDTO> response = controller.getRegistration(anyLong());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getRegistrationShouldReturnHttpStatusAndRegistrationDTO completed successfully");
    }

    @Test
    void editRegistrationShouldReturnHttpStatusAndRegistrationDTO() {
        ResponseEntity<RegistrationDTO> response = controller.editRegistration(id, getEntityDTO(), getBindingResult());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        log.info("test editRegistrationShouldReturnHttpStatusAndRegistrationDTO completed successfully");
    }

    @Test
    void editRegistrationShouldReturnError() {
        BindingResult bindingResult = getBindingResult();
        doReturn(true).when(bindingResult).hasErrors();

        assertThrows(ArgumentNotValidException.class, () -> controller.editRegistration(id, getEntityDTO(), bindingResult));
        log.info("test editRegistrationShouldReturnError completed successfully");
    }
}