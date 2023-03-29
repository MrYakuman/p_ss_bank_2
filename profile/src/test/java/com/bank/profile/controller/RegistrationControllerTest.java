package com.bank.profile.controller;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import com.bank.profile.service.serviceInterface.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
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

    static Registration getRegistration() {
        return new Registration();
    }

    static RegistrationDTO getRegistrationDTO() {
        return new RegistrationDTO();
    }

    static BindingResult getBindingResult() {
        return mock(BindingResult.class);
    }

    @Test
    void getAllRegistrationShouldReturnHttpStatusAndListTest() {
        List<Registration> registrations = new ArrayList<>();
        registrations.add(getRegistration());
        registrations.add(getRegistration());
        registrations.add(getRegistration());
        doReturn(registrations).when(service).getAllRegistration();

        ResponseEntity<List<RegistrationDTO>> response = controller.getAllRegistration();

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getAllRegistrationShouldReturnHttpStatusAndList completed successfully");
    }

    @Test
    void getRegistrationShouldReturnHttpStatusAndRegistrationDTO_Test() {
        doReturn(getRegistration()).when(service).findRegistrationById(anyLong());

        ResponseEntity<RegistrationDTO> response = controller.getRegistration(anyLong());

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getRegistrationShouldReturnHttpStatusAndRegistrationDTO completed successfully");
    }

    @Test
    void editRegistrationShouldReturnHttpStatusAndRegistrationDTO_Test() {
        ResponseEntity<RegistrationDTO> response = controller.editRegistration(id, getRegistrationDTO(), getBindingResult());

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        log.info("test editRegistrationShouldReturnHttpStatusAndRegistrationDTO completed successfully");
    }
}