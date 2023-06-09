package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.Registration;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.RegistrationRepository;
import com.bank.profile.service.serviceInterface.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    @Override
    public Registration findRegistrationById(long registrationId) {
        log.info("attempt to find Registration: id = {}", registrationId);
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new EntityNotFoundException(Registration.class.getSimpleName(), registrationId));
        log.info("Registration found: id = {}", registrationId);

        return registration;
    }

    @Override
    public boolean editRegistration(Long id, Registration registration) {
        log.info("attempt to update Registration: id = {}", id);
        registration.setId(id);
        registrationRepository.save(registration);
        log.info("updated Registration successfully: id = {}", id);
        return true;
    }


    @Override
    public List<Registration> getAllRegistration() {
        log.info("attempt to find all Registration");
        var allRegistration = registrationRepository.findAll();

        if (allRegistration.isEmpty()) {
            throw new EntityNotFoundException(Registration.class.getSimpleName());
        }

        log.info("found all Registration successfully, size = {}", allRegistration.size());

        return allRegistration;
    }
}
