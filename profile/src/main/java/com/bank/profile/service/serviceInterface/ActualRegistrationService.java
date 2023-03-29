package com.bank.profile.service.serviceInterface;

import com.bank.profile.entity.ActualRegistration;

import java.util.List;

public interface ActualRegistrationService {
    boolean saveActualRegistration(ActualRegistration actualRegistration);

    ActualRegistration findActualRegistrationById(long actualRegistrationId);

    boolean editActualRegistration(Long id, ActualRegistration actualRegistration);

    boolean deleteActualRegistration(long actualRegistrationId);

    List<ActualRegistration> getAllActualRegistration();
}
