package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Certificate;

import java.util.List;

public interface CertificateService {
    
    Certificate save(Certificate certificate);

    List<Certificate> getAll();
}
