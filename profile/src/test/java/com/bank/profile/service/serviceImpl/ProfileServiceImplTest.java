package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.Profile;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.ProfileRepository;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ProfileServiceImplTest {
    @InjectMocks
    @Spy
    private ProfileServiceImpl profileServiceImpl;

    @Mock
    private ProfileRepository profileRepository;

    static Profile getProfile() {
        return new Profile();
    }

    @Test
    void saveProfileShouldReturnTrueTest() {
        doReturn(getProfile()).when(profileRepository).save(getProfile());

        boolean b = profileServiceImpl.saveProfile(getProfile());

        verify(profileServiceImpl).saveProfile(any(Profile.class));
        Assertions.assertTrue(b);
        log.info("test saveProfileShouldReturnTrue completed successfully");
    }

    @Test
    void findProfileByIdShouldReturnProfileTest() {
        doReturn(Optional.of(getProfile())).when(profileRepository).findById(anyLong());

        Profile profile = profileServiceImpl.findProfileById(anyLong());

        verify(profileServiceImpl).findProfileById(anyLong());
        Assertions.assertEquals(getProfile(), profile);
        log.info("test findProfileByIdShouldReturnProfile completed successfully");
    }

    @Test
    void findProfileByIdShouldReturnErrorTest() {
        doThrow(EntityNotFoundException.class).when(profileRepository).findById(anyLong());

        Assertions.assertThrows(EntityNotFoundException.class, () -> profileServiceImpl.findProfileById(anyLong()));

        verify(profileServiceImpl).findProfileById(anyLong());
        log.info("test findProfileByIdShouldReturnError completed successfully");
    }

    @Test
    void editProfileShouldReturnUpdateProfileTest() {
        doReturn(getProfile()).when(profileRepository).save(any(Profile.class));

        boolean b = profileServiceImpl.editProfile(getProfile().getId(), getProfile());

        Assertions.assertTrue(b);
        verify(profileServiceImpl).editProfile(anyLong(), any(Profile.class));
        log.info("test editProfileShouldReturnUpdateProfile completed successfully");
    }

    @Test
    void deleteProfileShouldNothingReturnTest() {
        doNothing().when(profileRepository).deleteById(anyLong());

        Assertions.assertTrue(profileServiceImpl.deleteProfile(anyLong()));
        verify(profileServiceImpl).deleteProfile(anyLong());
        log.info("test deleteProfileShouldNothingReturn completed successfully");
    }

    @Test
    void deleteProfileShouldReturnErrorTest() {
        doThrow(EntityNotFoundException.class).when(profileRepository).deleteById(anyLong());

        Assertions.assertThrows(EntityNotFoundException.class, () -> profileServiceImpl.deleteProfile(anyLong()));
        verify(profileServiceImpl).deleteProfile(anyLong());
        log.info("test deleteProfileShouldReturnError completed successfully");
    }

    @Test
    void getAllProfileShouldReturnListTest() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(mock(Profile.class));
        profiles.add(mock(Profile.class));
        profiles.add(mock(Profile.class));
        doReturn(profiles).when(profileRepository).findAll();

        List<Profile> profilesExtend = profileServiceImpl.getAllProfile();

        Assertions.assertEquals(3, profilesExtend.size());
        verify(profileServiceImpl).getAllProfile();
        log.info("test getAllProfileShouldReturnList completed successfully");
    }

    @Test
    void getAllProfileShouldReturnErrorTest() {
        doThrow(EntityNotFoundException.class).when(profileRepository).findAll();

        Assertions.assertThrows(EntityNotFoundException.class, () -> profileServiceImpl.getAllProfile());
        verify(profileServiceImpl).getAllProfile();
        log.info("test getAllProfileShouldReturnList completed successfully");
    }
}