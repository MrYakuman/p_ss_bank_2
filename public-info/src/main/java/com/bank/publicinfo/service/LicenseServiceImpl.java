package com.bank.publicinfo.service;


import com.bank.publicinfo.entity.License;
import com.bank.publicinfo.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LicenseServiceImpl implements LicenseService{
    @Autowired
    private LicenseRepository licenseRepository;

    @Override
    public License save(License license) {
        return licenseRepository.save(license);
    }

    @Override
    @Transactional
    public List<License> getAll() {
        return licenseRepository.findAll();
    }
}
