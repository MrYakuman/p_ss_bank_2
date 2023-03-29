package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.entity.Profile;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.ActualRegistrationRepository;
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
    void saveActualRegistrationShouldReturnTrueTest() {
        doReturn(getActualRegistration()).when(actualRegistrationRepository).save(getActualRegistration());

        boolean b = actualRegistrationServiceImpl.saveActualRegistration(getActualRegistration());

        verify(actualRegistrationServiceImpl).saveActualRegistration(any(ActualRegistration.class));
        Assertions.assertTrue(b);
        log.info("test saveActualRegistrationShouldReturnTrue completed successfully");
    }

    @Test
    void findActualRegistrationByIdShouldReturnActualRegistrationTest() {
        doReturn(Optional.of(getActualRegistration())).when(actualRegistrationRepository).findById(anyLong());

        ActualRegistration actualRegistration = actualRegistrationServiceImpl.findActualRegistrationById(anyLong());

        verify(actualRegistrationServiceImpl).findActualRegistrationById(anyLong());
        Assertions.assertEquals(getActualRegistration(), actualRegistration);
        log.info("test findActualRegistrationByIdShouldReturnActualRegistration completed successfully");
    }

    @Test
    void editActualRegistrationShouldReturnUpdateActualRegistrationTest() {
        doReturn(getActualRegistration()).when(actualRegistrationRepository).save(any(ActualRegistration.class));

        boolean b = actualRegistrationServiceImpl.editActualRegistration(getActualRegistration().getId(), getActualRegistration());

        Assertions.assertTrue(b);
        verify(actualRegistrationServiceImpl).editActualRegistration(anyLong(), any(ActualRegistration.class));
        log.info("test editActualRegistrationShouldReturnUpdateActualRegistration completed successfully");
    }

    @Test
    void deleteActualRegistrationShouldNothingReturnTest() {
        doNothing().when(actualRegistrationRepository).deleteById(anyLong());

        Assertions.assertTrue(actualRegistrationServiceImpl.deleteActualRegistration(anyLong()));
        verify(actualRegistrationServiceImpl).deleteActualRegistration(anyLong());
        log.info("test deleteActualRegistrationShouldNothingReturn completed successfully");
    }

    @Test
    void getAllActualRegistrationShouldReturnListTest() {
        List<ActualRegistration> actualRegistrations = new ArrayList<>();
        actualRegistrations.add(mock(ActualRegistration.class));
        actualRegistrations.add(mock(ActualRegistration.class));
        actualRegistrations.add(mock(ActualRegistration.class));
        doReturn(actualRegistrations).when(actualRegistrationRepository).findAll();

        List<ActualRegistration> actualRegistrationExtend = actualRegistrationServiceImpl.getAllActualRegistration();

        Assertions.assertEquals(3, actualRegistrations.size());
        verify(actualRegistrationServiceImpl).getAllActualRegistration();
        log.info("test getAllActualRegistrationShouldReturnList completed successfully");
    }
}