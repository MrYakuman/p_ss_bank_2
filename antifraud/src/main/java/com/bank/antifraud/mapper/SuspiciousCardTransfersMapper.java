package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousCardTransfersDTO;
import com.bank.antifraud.entity.SuspiciousCardTransfers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SuspiciousCardTransfersMapper {
    SuspiciousCardTransfersMapper MAPPER = Mappers.getMapper(SuspiciousCardTransfersMapper.class);
    SuspiciousCardTransfersDTO toSuspiciousCardTransfersDTO(SuspiciousCardTransfers suspiciousCardTransfers);
    @Mapping(target = "id", ignore = true)
    SuspiciousCardTransfers toSuspiciousCardTransfers(SuspiciousCardTransfersDTO suspiciousCardTransfersDTO);
}
