package com.bank.profile.controller;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import com.bank.profile.mappers.ProfileMapper;
import com.bank.profile.service.serviceInterface.AuditService;
import com.bank.profile.service.serviceInterface.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ProfileControllerTest {
    @InjectMocks
    private ProfileController controller;
    @Mock
    private ProfileService service;
    @Mock
    private ProfileMapper mapper;
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private AuditService auditService;

    private Long id = 123L;


    static Profile getEntity() {
        return new Profile();
    }

    static ProfileDTO getEntityDTO() {
        return new ProfileDTO();
    }

    static BindingResult getBindingResult() {
        return mock(BindingResult.class);
    }

    @Test
    void getAllProfileShouldReturnHttpStatusAndListTest() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(getEntity());
        profiles.add(getEntity());
        profiles.add(getEntity());
        doReturn(profiles).when(service).getAllProfile();

        ResponseEntity<List<ProfileDTO>> response = controller.getAllProfile();

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getAllProfileShouldReturnHttpStatusAndList completed successfully");
    }

    @Test
    void getProfileShouldReturnHttpStatusAndProfileDTO_Test() {
        doReturn(getEntity()).when(service).findProfileById(anyLong());

        ResponseEntity<ProfileDTO> response = controller.getProfile(anyLong());

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("test getProfileShouldReturnHttpStatusAndProfileDTO completed successfully");
    }

    @SneakyThrows
    @Test
    void createProfileShouldReturnHttpStatusAndProfileDTO_Test() {
        doReturn("String").when(objectMapper).writeValueAsString(getEntity());

        ResponseEntity<ProfileDTO> response = controller.createProfile(getEntityDTO(), getBindingResult());

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        log.info("test createProfileShouldReturnHttpStatusAndProfileDTO completed successfully");
    }

    @SneakyThrows
    @Test
    void editProfileShouldReturnHttpStatusAndProfileDTO_Test() {
        doReturn("String").when(objectMapper).writeValueAsString(getEntity());
        doReturn(getEntity()).when(service).findProfileById(anyLong());

        ResponseEntity<ProfileDTO> response = controller.editProfile(id, getEntityDTO(), getBindingResult());

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        log.info("test editProfileShouldReturnHttpStatusAndProfileDTO completed successfully");
    }

    @Test
    void deleteProfileShouldReturnHttpStatusTest() {
        ResponseEntity<HttpStatus> response = controller.deleteProfile(anyLong());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        log.info("test deleteProfileShouldReturnHttpStatus completed successfully");
    }
}