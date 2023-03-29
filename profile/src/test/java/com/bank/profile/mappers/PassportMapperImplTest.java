package com.bank.profile.mappers;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class PassportMapperImplTest {
    @InjectMocks
    private PassportMapperImpl passportMapper;

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

    @Test
    void registrationToRegistrationDTO_ShouldReturnIdenticalRegistrationDTO_Test() {
        RegistrationDTO registrationDTO = passportMapper.registrationToRegistrationDTO(getRegistration());

        Assertions.assertEquals(getRegistrationDTO(), registrationDTO);
        log.info("test registrationToRegistrationDTOShouldReturnIdenticalRegistrationDTO completed successfully");
    }

    @Test
    void registrationDTOToRegistrationShouldReturnIdenticalRegistrationTest() {
        Registration registration = passportMapper.registrationDTOToRegistration(getRegistrationDTO());

        Assertions.assertEquals(getRegistration(), registration);
        log.info("test registrationDTOToRegistrationShouldReturnIdenticalRegistration completed successfully");
    }
}