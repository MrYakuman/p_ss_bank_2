package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.ActualRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ActualRegistrationServiceImplTest {

    @InjectMocks
    @Spy
    private ActualRegistrationServiceImpl actualRegistrationServiceImpl;

    @Mock
    private ActualRegistrationRepository actualRegistrationRepository;

    static ActualRegistration getActualRegistration() {
        return new ActualRegistration();
    }
    @Test
    void saveActualRegistrationShouldReturnTrue() {
        doReturn(getActualRegistration()).when(actualRegistrationRepository).save(getActualRegistration());

        boolean b = actualRegistrationServiceImpl.saveActualRegistration(getActualRegistration());

        assertTrue(b);
        verify(actualRegistrationServiceImpl).saveActualRegistration(any(ActualRegistration.class));
        log.info("test saveActualRegistrationShouldReturnTrue completed successfully");
    }

    @Test
    void findActualRegistrationByIdShouldReturnActualRegistration() {
        doReturn(Optional.of(getActualRegistration())).when(actualRegistrationRepository).findById(anyLong());

        ActualRegistration actualRegistration = actualRegistrationServiceImpl.findActualRegistrationById(anyLong());

        assertEquals(getActualRegistration(), actualRegistration);
        verify(actualRegistrationServiceImpl).findActualRegistrationById(anyLong());
        log.info("test findActualRegistrationByIdShouldReturnActualRegistration completed successfully");
    }

    @Test
    void findActualRegistrationByIdShouldReturnError() {
        assertThrows(EntityNotFoundException.class, () -> actualRegistrationServiceImpl.findActualRegistrationById(anyLong()));
        verify(actualRegistrationServiceImpl).findActualRegistrationById(anyLong());
        log.info("test findActualRegistrationByIdShouldReturnError completed successfully");
    }

    @Test
    void editActualRegistrationShouldReturnUpdateActualRegistration() {
        doReturn(getActualRegistration()).when(actualRegistrationRepository).save(any(ActualRegistration.class));

        boolean b = actualRegistrationServiceImpl.editActualRegistration(getActualRegistration().getId(), getActualRegistration());

        assertTrue(b);
        verify(actualRegistrationServiceImpl).editActualRegistration(anyLong(), any(ActualRegistration.class));
        log.info("test editActualRegistrationShouldReturnUpdateActualRegistration completed successfully");
    }

    @Test
    void deleteActualRegistrationShouldCompletedSuccessfully() {
        assertTrue(actualRegistrationServiceImpl.deleteActualRegistration(anyLong()));
        verify(actualRegistrationServiceImpl).deleteActualRegistration(anyLong());
        log.info("test deleteActualRegistrationShouldCompletedSuccessfully completed successfully");
    }

    @Test
    void deleteActualRegistrationShouldReturnError() {
        doThrow(EmptyResultDataAccessException.class).when(actualRegistrationRepository).deleteById(anyLong());

        assertThrows(EntityNotFoundException.class, () -> actualRegistrationServiceImpl.deleteActualRegistration(anyLong()));
        verify(actualRegistrationServiceImpl).deleteActualRegistration(anyLong());
        log.info("test deleteActualRegistrationShouldReturnError completed successfully");
    }

    @Test
    void getAllActualRegistrationShouldReturnList() {
        List<ActualRegistration> actualRegistrations = new ArrayList<>();
        actualRegistrations.add(mock(ActualRegistration.class));
        actualRegistrations.add(mock(ActualRegistration.class));
        actualRegistrations.add(mock(ActualRegistration.class));
        doReturn(actualRegistrations).when(actualRegistrationRepository).findAll();

        List<ActualRegistration> actualRegistrationExtend = actualRegistrationServiceImpl.getAllActualRegistration();

        assertEquals(actualRegistrations.size(), actualRegistrationExtend.size());
        verify(actualRegistrationServiceImpl).getAllActualRegistration();
        log.info("test getAllActualRegistrationShouldReturnList completed successfully");
    }

    @Test
    void getAllActualRegistrationShouldReturnError() {
        List<ActualRegistration> actualRegistrations = new ArrayList<>();
        doReturn(actualRegistrations).when(actualRegistrationRepository).findAll();

        assertThrows(EntityNotFoundException.class, () -> actualRegistrationServiceImpl.getAllActualRegistration());
        verify(actualRegistrationServiceImpl).getAllActualRegistration();
        log.info("test getAllActualRegistrationShouldReturnError completed successfully");
    }
}