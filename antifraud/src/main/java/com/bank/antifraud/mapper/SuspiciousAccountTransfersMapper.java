package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousAccountTransfersDTO;
import com.bank.antifraud.entity.SuspiciousAccountTransfers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SuspiciousAccountTransfersMapper {
    SuspiciousAccountTransfersMapper MAPPER = Mappers.getMapper(SuspiciousAccountTransfersMapper.class);
    SuspiciousAccountTransfersDTO toSuspiciousAccountTransfersDTO(SuspiciousAccountTransfers suspiciousAccountTransfers);
    @Mapping(target = "id", ignore = true)
    SuspiciousAccountTransfers toSuspiciousAccountTransfers(SuspiciousAccountTransfersDTO suspiciousAccountTransfersDTO);
}
