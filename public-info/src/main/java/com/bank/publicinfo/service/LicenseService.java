package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.entity.License;

import java.util.List;

public interface LicenseService {
    License save(License license);

    List<License> getAll();
}
