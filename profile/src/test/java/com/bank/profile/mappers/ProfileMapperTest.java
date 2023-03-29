package com.bank.profile.mappers;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ProfileMapperTest {
    @InjectMocks
    private ProfileMapperImpl profileMapper;

    Profile getProfile() {
        Profile profile = new Profile();

        profile.setPhoneNumber(9059998877L);
        profile.setEmail("petrov@mail.ru");
        profile.setNameOnCard("PETROV I");
        profile.setInn(3265_1456_9547L);
        profile.setSnils(1245_2541_3605_01L);
        profile.setPassportId(null);

        return profile;
    }

    ProfileDTO getProfileDTO() {
        ProfileDTO profile = new ProfileDTO();

        profile.setPhoneNumber(9059998877L);
        profile.setEmail("petrov@mail.ru");
        profile.setNameOnCard("PETROV I");
        profile.setInn(3265_1456_9547L);
        profile.setSnils(1245_2541_3605_01L);
        profile.setPassport(null);

        return profile;
    }


    @Test
    void toProfileDTOShouldReturnIdenticalProfileDTO_Test() {
        ProfileDTO profileDTO = profileMapper.toProfileDTO(getProfile());

        Assertions.assertEquals(getProfileDTO(), profileDTO);
        log.info("test toProfileDTOShouldReturnIdenticalProfileDTO completed successfully");
    }

    @Test
    void toProfileShouldReturnIdenticalProfileTest() {
        Profile profile = profileMapper.toProfile(getProfileDTO());

        Assertions.assertEquals(getProfile(), profile);
        log.info("test toProfileShouldReturnIdenticalProfile completed successfully");
    }


}