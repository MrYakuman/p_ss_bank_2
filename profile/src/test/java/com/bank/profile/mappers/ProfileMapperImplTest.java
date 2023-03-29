package com.bank.profile.mappers;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.dto.PassportDTO;
import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Registration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ProfileMapperImplTest {
    @InjectMocks
    private ProfileMapperImpl profileMapper;

    Passport getPassport() {
        Passport passport = new Passport();

        LocalDate birthDate = LocalDate.of(1994, 10, 13);
        LocalDate dateOfIssue = LocalDate.of(2011, 11, 5);
        LocalDate expirationDate = LocalDate.of(2032, 10, 13);

        passport.setSeries(2415);
        passport.setNumber(241536);
        passport.setLastName("Петров");
        passport.setFirstName("Игорь");
        passport.setMiddleName("Сергеевич");
        passport.setGender("МУЖ");
        passport.setBirthDate(birthDate);
        passport.setBirthPlace("Москва, Московская область, Российская федерация");
        passport.setIssuedBy("УМВД РФ по Ленинскому р-н г. Москвы");
        passport.setDateOfIssue(dateOfIssue);
        passport.setDivisionCode(365214);
        passport.setExpirationDate(expirationDate);
        passport.setRegistrationId(null);

        return passport;
    }

    PassportDTO getPassportDTO() {
        PassportDTO passport = new PassportDTO();

        LocalDate birthDate = LocalDate.of(1994, 10, 13);
        LocalDate dateOfIssue = LocalDate.of(2011, 11, 5);
        LocalDate expirationDate = LocalDate.of(2032, 10, 13);

        passport.setSeries(2415);
        passport.setNumber(241536);
        passport.setLastName("Петров");
        passport.setFirstName("Игорь");
        passport.setMiddleName("Сергеевич");
        passport.setGender("МУЖ");
        passport.setBirthDate(birthDate);
        passport.setBirthPlace("Москва, Московская область, Российская федерация");
        passport.setIssuedBy("УМВД РФ по Ленинскому р-н г. Москвы");
        passport.setDateOfIssue(dateOfIssue);
        passport.setDivisionCode(365214);
        passport.setExpirationDate(expirationDate);
        passport.setRegistration(null);

        return passport;
    }

    Registration getRegistration() {
        Registration registration = new Registration();

        registration.setCountry("Российская Федерация");
        registration.setRegion("Московская область");
        registration.setCity("Москва");
        registration.setDistrict("Ленинский р-н");
        registration.setStreet("Пирогова");
        registration.setHouseNumber("42");
        registration.setFlatNumber("14");
        registration.setIndex(142536);

        return registration;
    }

    RegistrationDTO getRegistrationDTO() {
        RegistrationDTO registration = new RegistrationDTO();

        registration.setCountry("Российская Федерация");
        registration.setRegion("Московская область");
        registration.setCity("Москва");
        registration.setDistrict("Ленинский р-н");
        registration.setStreet("Пирогова");
        registration.setHouseNumber("42");
        registration.setFlatNumber("14");
        registration.setIndex(142536);

        return registration;
    }

    ActualRegistration getActualRegistration() {
        ActualRegistration registration = new ActualRegistration();

        registration.setCountry("Российская Федерация");
        registration.setRegion("Московская область");
        registration.setCity("Москва");
        registration.setDistrict("Ленинский р-н");
        registration.setStreet("Пирогова");
        registration.setHouseNumber("42");
        registration.setFlatNumber("14");
        registration.setIndex(142536);

        return registration;
    }

    ActualRegistrationDTO getActualRegistrationDTO() {
        ActualRegistrationDTO registration = new ActualRegistrationDTO();

        registration.setCountry("Российская Федерация");
        registration.setRegion("Московская область");
        registration.setCity("Москва");
        registration.setDistrict("Ленинский р-н");
        registration.setStreet("Пирогова");
        registration.setHouseNumber("42");
        registration.setFlatNumber("14");
        registration.setIndex(142536);

        return registration;
    }

    @Test
    void registrationToRegistrationDTO_ShouldReturnIdenticalRegistrationDTO_Test() {
        RegistrationDTO registrationDTO = profileMapper.registrationToRegistrationDTO(getRegistration());

        Assertions.assertEquals(getRegistrationDTO(), registrationDTO);
        log.info("test registrationToRegistrationDTOShouldReturnIdenticalRegistrationDTO completed successfully");
    }

    @Test
    void passportToPassportDTO_ShouldReturnIdenticalPassportDTO_Test() {
        PassportDTO passportDTO = profileMapper.passportToPassportDTO(getPassport());

        Assertions.assertEquals(getPassportDTO(), passportDTO);
        log.info("test passportToPassportDTOShouldReturnIdenticalPassportDTO completed successfully");
    }

    @Test
    void actualRegistrationToActualRegistrationDTO_ShouldReturnIdenticalActualRegistrationDTO_Test() {
        ActualRegistrationDTO actualRegistrationDTO = profileMapper.actualRegistrationToActualRegistrationDTO(getActualRegistration());

        Assertions.assertEquals(getActualRegistrationDTO(), actualRegistrationDTO);
        log.info("test actualRegistrationToActualRegistrationDTO_ShouldReturnIdenticalActualRegistrationDTO completed successfully");
    }

    @Test
    void registrationDTOToRegistrationShouldReturnIdenticalRegistrationTest() {
        Registration registration = profileMapper.registrationDTOToRegistration(getRegistrationDTO());

        Assertions.assertEquals(getRegistration(), registration);
        log.info("test registrationDTOToRegistrationShouldReturnIdenticalRegistration completed successfully");
    }

    @Test
    void passportDTOToPassportShouldReturnIdenticalPassportTest() {
        Passport passport = profileMapper.passportDTOToPassport(getPassportDTO());

        Assertions.assertEquals(getPassport(), passport);
        log.info("test passportDTOToPassportShouldReturnIdenticalPassport completed successfully");
    }

    @Test
    void actualRegistrationDTOToActualRegistrationShouldReturnIdenticalActualRegistrationTest() {
        ActualRegistration actualRegistration = profileMapper.actualRegistrationDTOToActualRegistration(getActualRegistrationDTO());

        Assertions.assertEquals(getActualRegistration(), actualRegistration);
        log.info("test actualRegistrationDTOToActualRegistrationShouldReturnIdenticalActualRegistration completed successfully");
    }
}