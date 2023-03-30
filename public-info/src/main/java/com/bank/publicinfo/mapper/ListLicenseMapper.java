package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.entity.License;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = LicenseMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ListLicenseMapper {

    List<License> toListLicense(List<LicenseDTO> licenseDTOList);

    List<LicenseDTO> toLicenseDTO(List<License> licenseList);
}
