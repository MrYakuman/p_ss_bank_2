package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.ActualRegistrationRepository;
import com.bank.profile.service.serviceInterface.ActualRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ActualRegistrationServiceImpl implements ActualRegistrationService {
    private final ActualRegistrationRepository actualRegistrationRepository;

    public ActualRegistrationServiceImpl(ActualRegistrationRepository actualRegistrationRepository) {
        this.actualRegistrationRepository = actualRegistrationRepository;
    }

    @Override
    public boolean saveActualRegistration(ActualRegistration actualRegistration) {
        log.info("attempt to save ActualRegistration");
        actualRegistrationRepository.save(actualRegistration);
        log.info("saved ActualRegistration successfully: id = {}", actualRegistration.getId());
        return true;
    }

    @Override
    public ActualRegistration findActualRegistrationById(long actualRegistrationId) {
        log.info("attempt to find ActualRegistration: id = {}", actualRegistrationId);
        ActualRegistration actualRegistration = actualRegistrationRepository.findById(actualRegistrationId)
                .orElseThrow(() -> new EntityNotFoundException(ActualRegistration.class.getSimpleName(), actualRegistrationId));
        log.info("ActualRegistration found: id = {}", actualRegistrationId);

        return actualRegistration;
    }

    @Override
    public boolean editActualRegistration(Long id, ActualRegistration actualRegistration) {
        log.info("attempt to update ActualRegistration: id = {}", id);
        actualRegistration.setId(id);
        actualRegistrationRepository.save(actualRegistration);
        log.info("updated ActualRegistration successfully: id = {}", id);
        return true;
    }

    @Override
    public boolean deleteActualRegistration(long actualRegistrationId) {
        log.info("attempt to delete ActualRegistration: {}", actualRegistrationId);

        try {
            actualRegistrationRepository.deleteById(actualRegistrationId);
            log.info("deleted ActualRegistration successfully: id = {}", actualRegistrationId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(ActualRegistration.class.getSimpleName(), actualRegistrationId, e);
        }
    }

    @Override
    public List<ActualRegistration> getAllActualRegistration() {
        log.info("attempt to find all ActualRegistration");
        var allActualRegistration = actualRegistrationRepository.findAll();

        if (allActualRegistration.isEmpty()) {
            throw new EntityNotFoundException(ActualRegistration.class.getSimpleName());
        }
        log.info("found all ActualRegistration successfully, size = {}", allActualRegistration.size());

        return allActualRegistration;
    }
}
