package com.bank.publicinfo.mapper;


import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.entity.License;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LicenseMapper {

    License toLicense(LicenseDTO licenseDTO);

    LicenseDTO toLicenseDTO(License license);

    List<License> toListLicense(List<LicenseDTO> licenseDTOList);

    List<LicenseDTO> toListLicenseDto(List<License> licenses);
}
