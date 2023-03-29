package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.Registration;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.RegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    void findRegistrationByIdShouldReturnRegistrationTest() {
        doReturn(Optional.of(getRegistration())).when(registrationRepository).findById(anyLong());

        Registration registration = registrationServiceImpl.findRegistrationById(anyLong());

        verify(registrationServiceImpl).findRegistrationById(anyLong());
        Assertions.assertEquals(getRegistration(), registration);
        log.info("test findRegistrationByIdShouldReturnRegistration completed successfully");
    }

    @Test
    void findRegistrationByIdShouldReturnErrorTest() {
        doThrow(EntityNotFoundException.class).when(registrationRepository).findById(anyLong());

        Assertions.assertThrows(EntityNotFoundException.class, () -> registrationServiceImpl.findRegistrationById(anyLong()));

        verify(registrationServiceImpl).findRegistrationById(anyLong());
        log.info("test findRegistrationByIdShouldReturnError completed successfully");
    }

    @Test
    void editRegistrationShouldReturnUpdateRegistrationTest() {
        doReturn(getRegistration()).when(registrationRepository).save(any(Registration.class));

        boolean b = registrationServiceImpl.editRegistration(getRegistration().getId(), getRegistration());

        Assertions.assertTrue(b);
        verify(registrationServiceImpl).editRegistration(anyLong(), any(Registration.class));
        log.info("test editRegistrationShouldReturnUpdateRegistration completed successfully");
    }

    @Test
    void getAllRegistrationShouldReturnListTest() {
        List<Registration> registrations = new ArrayList<>();
        registrations.add(mock(Registration.class));
        registrations.add(mock(Registration.class));
        registrations.add(mock(Registration.class));
        doReturn(registrations).when(registrationRepository).findAll();

        List<Registration> registrationExtend = registrationServiceImpl.getAllRegistration();

        Assertions.assertEquals(3, registrationExtend.size());
        verify(registrationServiceImpl).getAllRegistration();
        log.info("test getAllRegistrationShouldReturnList completed successfully");
    }
}