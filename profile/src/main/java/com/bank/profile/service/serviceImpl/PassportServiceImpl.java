package com.bank.profile.service.serviceImpl;

import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Profile;
import com.bank.profile.exception.EntityNotFoundException;
import com.bank.profile.repository.PassportRepository;
import com.bank.profile.service.serviceInterface.PassportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public void savePassport(Passport passport) {
        log.info("attempt to save Passport");
        passportRepository.save(passport);
        log.info("saved Passport successfully: id = {}", passport.getId());
    }

    @Override
    public Passport findPassportById(long passportId) {
        log.info("attempt to find Passport: id = {}", passportId);
        Passport passport = passportRepository.findById(passportId)
                .orElseThrow(() -> new EntityNotFoundException(Passport.class.getSimpleName(), passportId));
        log.info("Passport found: id = {}", passportId);

        return passport;
    }

    @Override
    public void editPassport(Long id, Passport passport) {
        log.info("attempt to update Passport: id = {}", id);
        passport.setId(id);
        passportRepository.save(passport);
        log.info("updated Passport successfully: id = {}", id);
    }

    @Override
    public void deletePassport(long passportId) {
        log.info("attempt to delete Passport: {}", passportId);

        try {
            passportRepository.deleteById(passportId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(Passport.class.getSimpleName(), passportId, e);
        }

        log.info("deleted Passport successfully: id = {}", passportId);
    }

    @Override
    public List<Passport> getAllPassport() {
        log.info("attempt to find all Passport");
        var allPassport = passportRepository.findAll();

        if (allPassport.isEmpty()) {
            throw new EntityNotFoundException(Passport.class.getSimpleName());
        }

        log.info("found all Passport successfully, size = {}", allPassport.size());

        return allPassport;
    }
}
