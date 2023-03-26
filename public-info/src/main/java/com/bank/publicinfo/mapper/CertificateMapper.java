package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.CertificateDTO;
import com.bank.publicinfo.entity.Certificate;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CertificateMapper {

    Certificate toCertificate(CertificateDTO certificateDTO);

    CertificateDTO toCertificateDTO(Certificate certificate);

    List<Certificate> toListCertificate(List<CertificateDTO> certificateDTOList);

    List<CertificateDTO> toListCertificateDto(List<Certificate> certificateList);
}
