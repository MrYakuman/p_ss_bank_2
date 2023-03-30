package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.Profile;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.ProfileRepository;
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
    void saveProfileShouldReturnTrue() {
        doReturn(getProfile()).when(profileRepository).save(getProfile());

        boolean b = profileServiceImpl.saveProfile(getProfile());

        assertTrue(b);
        verify(profileServiceImpl).saveProfile(any(Profile.class));
        log.info("test saveProfileShouldReturnTrue completed successfully");
    }

    @Test
    void findProfileByIdShouldReturnProfile() {
        doReturn(Optional.of(getProfile())).when(profileRepository).findById(anyLong());

        Profile profile = profileServiceImpl.findProfileById(anyLong());

        assertEquals(getProfile(), profile);
        verify(profileServiceImpl).findProfileById(anyLong());
        log.info("test findProfileByIdShouldReturnProfile completed successfully");
    }

    @Test
    void findProfileByIdShouldReturnError() {
        assertThrows(EntityNotFoundException.class, () -> profileServiceImpl.findProfileById(anyLong()));
        verify(profileServiceImpl).findProfileById(anyLong());
        log.info("test findProfileByIdShouldReturnError completed successfully");
    }

    @Test
    void editProfileShouldReturnUpdateProfile() {
        doReturn(getProfile()).when(profileRepository).save(getProfile());

        boolean b = profileServiceImpl.editProfile(getProfile().getId(), getProfile());

        assertTrue(b);
        verify(profileServiceImpl).editProfile(anyLong(), any(Profile.class));
        log.info("test editProfileShouldReturnUpdateProfile completed successfully");
    }

    @Test
    void deleteProfileShouldCompletedSuccessfully() {
        assertTrue(profileServiceImpl.deleteProfile(anyLong()));
        verify(profileServiceImpl).deleteProfile(anyLong());
        log.info("test deleteProfileShouldCompletedSuccessfully completed successfully");
    }

    @Test
    void deleteProfileShouldReturnErrorTest() {
        doThrow(EmptyResultDataAccessException.class).when(profileRepository).deleteById(anyLong());

        assertThrows(EntityNotFoundException.class, () -> profileServiceImpl.deleteProfile(anyLong()));
        verify(profileServiceImpl).deleteProfile(anyLong());
        log.info("test deleteProfileShouldReturnError completed successfully");
    }

    @Test
    void getAllProfileShouldReturnList() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(mock(Profile.class));
        profiles.add(mock(Profile.class));
        profiles.add(mock(Profile.class));
        doReturn(profiles).when(profileRepository).findAll();

        List<Profile> profilesExtend = profileServiceImpl.getAllProfile();

        assertEquals(profiles.size(), profilesExtend.size());
        verify(profileServiceImpl).getAllProfile();
        log.info("test getAllProfileShouldReturnList completed successfully");
    }

    @Test
    void getAllProfileShouldReturnError() {
        List<Profile> profiles = new ArrayList<>();
        doReturn(profiles).when(profileRepository).findAll();

        assertThrows(EntityNotFoundException.class, () -> profileServiceImpl.getAllProfile());
        verify(profileServiceImpl).getAllProfile();
        log.info("test getAllProfileShouldReturnError completed successfully");
    }
}