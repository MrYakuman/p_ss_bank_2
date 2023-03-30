package com.bank.profile.controller;

import com.bank.profile.dto.AccountDetailsIdDTO;
import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.exception.ArgumentNotValidException;
import com.bank.profile.service.serviceInterface.AccountDetailsIdService;
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
class AccountDetailsIdControllerTest {
    @InjectMocks
    private AccountDetailsIdController controller;
    @Mock
    private AccountDetailsIdService service;
    private Long id = 123L;

    static AccountDetailsId getEntity() {
        return new AccountDetailsId();
    }

    static AccountDetailsIdDTO getEntityDTO() {
        return new AccountDetailsIdDTO();
    }

    static BindingResult getBindingResult() {
        return mock(BindingResult.class);
    }

    @Test
    void getAllAccountDetailsIdShouldReturnHttpStatusAndList() {
        List<AccountDetailsId> accountDetailsIds = new ArrayList<>();
        accountDetailsIds.add(getEntity());
        accountDetailsIds.add(getEntity());
        accountDetailsIds.add(getEntity());
        doReturn(accountDetailsIds).when(service).getAllAccountDetailsId();

        ResponseEntity<List<AccountDetailsIdDTO>> response = controller.getAllAccountDetailsId();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getAllAccountDetailsIdShouldReturnHttpStatusAndList completed successfully");
    }

    @Test
    void getAccountDetailsIdShouldReturnHttpStatusAndActualAccountDetailsIdDTO() {
        doReturn(getEntity()).when(service).findAccountDetailsIdById(anyLong());

        ResponseEntity<AccountDetailsIdDTO> response = controller.getAccountDetailsId(anyLong());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getAccountDetailsIdShouldReturnHttpStatusAndActualAccountDetailsIdDTO completed successfully");
    }

    @Test
    void createAccountDetailsIdShouldReturnHttpStatusAndActualAccountDetailsIdDTO() {
        ResponseEntity<AccountDetailsIdDTO> response = controller.createAccountDetailsId(getEntityDTO(), getBindingResult());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        log.info("test createAccountDetailsIdShouldReturnHttpStatusAndActualAccountDetailsIdDTO completed successfully");
    }

    @Test
    void createAccountDetailsIdShouldReturnError() {
        BindingResult bindingResult = getBindingResult();
        doReturn(true).when(bindingResult).hasErrors();

        assertThrows(ArgumentNotValidException.class, () -> controller.createAccountDetailsId(getEntityDTO(), bindingResult));
        log.info("test createAccountDetailsIdShouldReturnError completed successfully");
    }

    @Test
    void editAccountDetailsIdShouldReturnHttpStatusAndActualAccountDetailsIdDTO() {
        ResponseEntity<AccountDetailsIdDTO> response = controller.editAccountDetailsId(id, getEntityDTO(), getBindingResult());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        log.info("test editAccountDetailsIdShouldReturnHttpStatusAndActualAccountDetailsIdDTO completed successfully");
    }

    @Test
    void editAccountDetailsIdShouldReturnError() {
        BindingResult bindingResult = getBindingResult();
        doReturn(true).when(bindingResult).hasErrors();

        assertThrows(ArgumentNotValidException.class, () -> controller.editAccountDetailsId(id, getEntityDTO(), bindingResult));
        log.info("test editAccountDetailsIdShouldReturnError completed successfully");
    }

    @Test
    void deleteAccountDetailsIdShouldReturnHttpStatus() {
        ResponseEntity<HttpStatus> response = controller.deleteAccountDetailsId(anyLong());

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        log.info("test deleteAccountDetailsIdShouldReturnHttpStatus completed successfully");
    }
}