package com.bank.profile.service.serviceInterface;

import com.bank.profile.entity.Profile;

import java.util.List;


public interface ProfileService {
    boolean saveProfile(Profile profile);

    Profile findProfileById(long profileId);

    boolean editProfile(Long id, Profile profile);

    boolean deleteProfile(long profileId);

    List<Profile> getAllProfile();

}
