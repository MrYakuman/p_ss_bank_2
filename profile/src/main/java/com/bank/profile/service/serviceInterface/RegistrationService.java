package com.bank.profile.service.serviceInterface;

import com.bank.profile.entity.Registration;

import java.util.List;


public interface RegistrationService {
    Registration findRegistrationById(long registrationId);

    boolean editRegistration(Long id, Registration registration);

    List<Registration> getAllRegistration();
}
