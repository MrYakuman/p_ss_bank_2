package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.Registration;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.RegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class RegistrationServiceImplTest {
    @InjectMocks
    @Spy
    private RegistrationServiceImpl registrationServiceImpl;

    @Mock
    private RegistrationRepository registrationRepository;

    static Registration getRegistration() {
        return new Registration();
    }

    @Test
    void findRegistrationByIdShouldReturnRegistration() {
        doReturn(Optional.of(getRegistration())).when(registrationRepository).findById(anyLong());

        Registration registration = registrationServiceImpl.findRegistrationById(anyLong());

        assertEquals(getRegistration(), registration);
        verify(registrationServiceImpl).findRegistrationById(anyLong());
        log.info("test findRegistrationByIdShouldReturnRegistration completed successfully");
    }

    @Test
    void findRegistrationByIdShouldReturnError() {
        assertThrows(EntityNotFoundException.class, () -> registrationServiceImpl.findRegistrationById(anyLong()));

        verify(registrationServiceImpl).findRegistrationById(anyLong());
        log.info("test findRegistrationByIdShouldReturnError completed successfully");
    }

    @Test
    void editRegistrationShouldReturnUpdateRegistration() {
        doReturn(getRegistration()).when(registrationRepository).save(any(Registration.class));

        boolean b = registrationServiceImpl.editRegistration(getRegistration().getId(), getRegistration());

        assertTrue(b);
        verify(registrationServiceImpl).editRegistration(anyLong(), any(Registration.class));
        log.info("test editRegistrationShouldReturnUpdateRegistration completed successfully");
    }

    @Test
    void getAllRegistrationShouldReturnList() {
        List<Registration> registrations = new ArrayList<>();
        registrations.add(mock(Registration.class));
        registrations.add(mock(Registration.class));
        registrations.add(mock(Registration.class));
        doReturn(registrations).when(registrationRepository).findAll();

        List<Registration> registrationExtend = registrationServiceImpl.getAllRegistration();

        assertEquals(registrations.size(), registrationExtend.size());
        verify(registrationServiceImpl).getAllRegistration();
        log.info("test getAllRegistrationShouldReturnList completed successfully");
    }

    @Test
    void getAllRegistrationShouldReturnError() {
        List<Registration> registrations = new ArrayList<>();
        doReturn(registrations).when(registrationRepository).findAll();

        assertThrows(EntityNotFoundException.class, () -> registrationServiceImpl.getAllRegistration());
        verify(registrationServiceImpl).getAllRegistration();
        log.info("test getAllRegistrationShouldReturnError completed successfully");
    }

}