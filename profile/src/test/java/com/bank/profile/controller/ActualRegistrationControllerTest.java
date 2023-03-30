package com.bank.profile.controller;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.exception.ArgumentNotValidException;
import com.bank.profile.service.serviceInterface.ActualRegistrationService;
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
class ActualRegistrationControllerTest {
    @InjectMocks
    private ActualRegistrationController controller;
    @Mock
    private ActualRegistrationService service;
    private Long id = 123L;

    static ActualRegistration getEntity() {
        return new ActualRegistration();
    }

    static ActualRegistrationDTO getEntityDTO() {
        return new ActualRegistrationDTO();
    }

    static BindingResult getBindingResult() {
        return mock(BindingResult.class);
    }

    @Test
    void getAllActualRegistrationShouldReturnHttpStatusAndList() {
        List<ActualRegistration> actualRegistrations = new ArrayList<>();
        actualRegistrations.add(getEntity());
        actualRegistrations.add(getEntity());
        actualRegistrations.add(getEntity());
        doReturn(actualRegistrations).when(service).getAllActualRegistration();

        ResponseEntity<List<ActualRegistrationDTO>> response = controller.getAllActualRegistration();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getAllActualRegistrationShouldReturnHttpStatusAndList completed successfully");
    }

    @Test
    void getActualRegistrationShouldReturnHttpStatusAndActualRegistrationDTO() {
        doReturn(getEntity()).when(service).findActualRegistrationById(anyLong());

        ResponseEntity<ActualRegistrationDTO> response = controller.getActualRegistration(anyLong());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getActualRegistrationShouldReturnHttpStatusAndActualRegistrationDTO completed successfully");
    }

    @Test
    void createActualRegistrationShouldReturnHttpStatusAndActualRegistrationDTO() {
        ResponseEntity<ActualRegistrationDTO> response = controller.createActualRegistration(getEntityDTO(), getBindingResult());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        log.info("test createActualRegistrationShouldReturnHttpStatusAndActualRegistrationDTO completed successfully");
    }

    @Test
    void createActualRegistrationShouldReturnError() {
        BindingResult bindingResult = getBindingResult();
        doReturn(true).when(bindingResult).hasErrors();

        assertThrows(ArgumentNotValidException.class, () -> controller.createActualRegistration(getEntityDTO(),bindingResult));
        log.info("test createActualRegistrationShouldReturnError completed successfully");
    }

    @Test
    void editActualRegistrationShouldReturnHttpStatusAndActualRegistrationDTO() {
        ResponseEntity<ActualRegistrationDTO> response = controller.editActualRegistration(id, getEntityDTO(), getBindingResult());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        log.info("test editActualRegistrationShouldReturnHttpStatusAndActualRegistrationDTO completed successfully");
    }

    @Test
    void editActualRegistrationShouldReturnError() {
        BindingResult bindingResult = getBindingResult();
        doReturn(true).when(bindingResult).hasErrors();

        assertThrows(ArgumentNotValidException.class, () -> controller.editActualRegistration(id, getEntityDTO(), bindingResult));
        log.info("test editActualRegistrationShouldReturnHttpStatusAndActualRegistrationDTO completed successfully");
    }

    @Test
    void deleteActualRegistrationShouldReturnHttpStatus() {
        ResponseEntity<HttpStatus> response = controller.deleteActualRegistration(anyLong());

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        log.info("test deleteActualRegistrationShouldReturnHttpStatus completed successfully");
    }
}