package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.Passport;
import com.bank.profile.repository.PassportRepository;
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
class PassportServiceImplTest {
    @InjectMocks
    @Spy
    private PassportServiceImpl passportServiceImpl;

    @Mock
    private PassportRepository passportRepository;

    static Passport getPassport() {
        return new Passport();
    }

    @Test
    void findPassportByIdShouldReturnPassportTest() {
        doReturn(Optional.of(getPassport())).when(passportRepository).findById(anyLong());

        Passport passport = passportServiceImpl.findPassportById(anyLong());

        verify(passportServiceImpl).findPassportById(anyLong());
        Assertions.assertEquals(getPassport(), passport);
        log.info("test findPassportByIdShouldReturnPassport completed successfully");
    }

    @Test
    void editPassportShouldReturnUpdatePassportTest() {
        doReturn(getPassport()).when(passportRepository).save(any(Passport.class));

        boolean b = passportServiceImpl.editPassport(getPassport().getId(), getPassport());

        Assertions.assertTrue(b);
        verify(passportServiceImpl).editPassport(anyLong(), any(Passport.class));
        log.info("test editPassportShouldReturnUpdatePassport completed successfully");
    }

    @Test
    void getAllPassportShouldReturnListTest() {
        List<Passport> passports = new ArrayList<>();
        passports.add(mock(Passport.class));
        passports.add(mock(Passport.class));
        passports.add(mock(Passport.class));
        doReturn(passports).when(passportRepository).findAll();

        List<Passport> passportExtend = passportServiceImpl.getAllPassport();

        Assertions.assertEquals(3, passportExtend.size());
        verify(passportServiceImpl).getAllPassport();
        log.info("test getAllPassportShouldReturnList completed successfully");
    }
}