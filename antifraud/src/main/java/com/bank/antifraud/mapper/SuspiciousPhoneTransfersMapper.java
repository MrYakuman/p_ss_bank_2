package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousPhoneTransfersDTO;
import com.bank.antifraud.entity.SuspiciousPhoneTransfers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SuspiciousPhoneTransfersMapper {
    SuspiciousPhoneTransfersMapper MAPPER = Mappers.getMapper(SuspiciousPhoneTransfersMapper.class);
    SuspiciousPhoneTransfersDTO toSuspiciousPhoneTransfersDTO(SuspiciousPhoneTransfers suspiciousPhoneTransfers);
    @Mapping(target = "id", ignore = true)
    SuspiciousPhoneTransfers toSuspiciousPhoneTransfers(SuspiciousPhoneTransfersDTO suspiciousPhoneTransfersDTO);
}
