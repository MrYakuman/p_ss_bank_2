package com.bank.publicinfo.service;


import com.bank.publicinfo.entity.Certificate;
import com.bank.publicinfo.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService{

    @Autowired
    CertificateRepository certificateRepository;

    @Override
    @Transactional
    public Certificate save(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    @Transactional
    public List<Certificate> getAll() {
        return certificateRepository.findAll();
    }
}
