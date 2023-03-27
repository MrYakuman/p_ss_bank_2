package com.bank.publicinfo.controller;


import com.bank.publicinfo.dto.CertificateDTO;
import com.bank.publicinfo.entity.Certificate;
import com.bank.publicinfo.entity.License;
import com.bank.publicinfo.mapper.CertificateMapper;
import com.bank.publicinfo.mapper.ListCertificateMapper;
import com.bank.publicinfo.service.AuditService;
import com.bank.publicinfo.service.CertificateService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/certificate")
@Slf4j
public class CertificateController {
    @Autowired
    CertificateService certificateService;

    @Autowired
    AuditService auditService;

    @Autowired
    private CertificateMapper certificateMapper;

    @Autowired
    private ListCertificateMapper listCertificateMapper;



    /**
     *
     * @param certificate
     * @return
     */
    @Schema(description = "")
    @PostMapping
    public CertificateDTO postCertificate(Certificate certificate) {
        CertificateDTO res = certificateMapper.toCertificateDTO(certificateService.save(certificate));
        return res;
    }

    /**
     *
     * @return лист дто лицензий
     */
    @GetMapping("/all")
    public List<CertificateDTO> getAllCertificate() {
        log.info("Пришёл запрос на получение всех сертификатов");

        return listCertificateMapper.toListCertificateDTO(certificateService.getAll());
    }
}
