package com.bank.profile.service.serviceInterface;

import com.bank.profile.entity.Passport;

import java.util.List;

public interface PassportService {
    Passport findPassportById(long passportId);

    boolean editPassport(Long id, Passport passport);

    List<Passport> getAllPassport();
}
