package com.bank.publicinfo.mapper;


import com.bank.publicinfo.dto.CertificateDTO;
import com.bank.publicinfo.entity.Certificate;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CertificateMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ListCertificateMapper {

    List<Certificate> toListCertificate(List<CertificateDTO> certificateDTOList);

    List<CertificateDTO> toListCertificateDTO(List<Certificate> certificateList);

}
