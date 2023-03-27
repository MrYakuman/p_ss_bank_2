package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.Profile;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.ProfileRepository;
import com.bank.profile.service.serviceInterface.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;


    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void saveProfile(Profile profile) {
        log.info("attempt to save Profile");
        profileRepository.save(profile);
        log.info("saved Profile successfully: id = {}", profile.getId());

    }

    @Override
    public Profile findProfileById(long profileId) {
        log.info("attempt to find Profile: id = {}", profileId);
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new EntityNotFoundException(Profile.class.getSimpleName(), profileId));
        log.info("Profile found: id = {}", profileId);

        return profile;
    }

    @Override
    public void editProfile(Long id, Profile profile) {
        log.info("attempt to update Profile: id = {}", id);
        profile.setId(id);
        profileRepository.save(profile);
        log.info("updated Profile successfully: id = {}", id);
    }

    @Override
    public void deleteProfile(long profileId) {
        log.info("attempt to delete Profile: {}", profileId);

        try {
            profileRepository.deleteById(profileId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(Profile.class.getSimpleName(), profileId, e);
        }

        log.info("deleted Profile successfully: id = {}", profileId);
    }

    @Override
    public List<Profile> getAllProfile() {
        log.info("attempt to find all Profile");
        var allProfile = profileRepository.findAll();

        if (allProfile.isEmpty()) {
            throw new EntityNotFoundException(Profile.class.getSimpleName());
        }

        log.info("found all Profile successfully, size = {}", allProfile.size());

        return allProfile;
    }
}
