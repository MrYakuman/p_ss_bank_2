package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.entity.License;
import com.bank.publicinfo.mapper.LicenseMapper;
import com.bank.publicinfo.mapper.ListLicenseMapper;
import com.bank.publicinfo.service.AuditService;
import com.bank.publicinfo.service.LicenseService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/license")
@Slf4j
public class LicenseController {
    @Autowired
    LicenseService licenseService;

    @Autowired
    AuditService auditService;

    @Autowired
    private LicenseMapper licenseMapper;

    @Autowired
    private ListLicenseMapper listLicenseMapper;

    @GetMapping
    public License test() {

        return new License(1, "photo", null);
    }

    /**
     *
     * @param license
     * @return
     */
    @Schema(description = "")
    @PostMapping
    public LicenseDTO postLicense(License license) {
        LicenseDTO res = licenseMapper.toLicenseDTO(licenseService.save(license));
//        auditService.audit(res, license);
        return res;
    }

    /**
     *
     * @return лист дто лицензий
     */
    @GetMapping("/all")
    public List<LicenseDTO> getAllByBankDetails() {
        log.info("Пришёл запрос на получение всех лицензий");

        return listLicenseMapper.toLicenseDTO(licenseService.getAll());
    }
}
