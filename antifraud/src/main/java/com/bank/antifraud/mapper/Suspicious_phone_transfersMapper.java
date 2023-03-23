package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.Suspicious_phone_transfersDTO;
import com.bank.antifraud.entity.Suspicious_phone_transfers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Suspicious_phone_transfersMapper {
    Suspicious_phone_transfersMapper MAPPER = Mappers.getMapper(Suspicious_phone_transfersMapper.class);
    Suspicious_phone_transfersDTO toSuspicious_phone_transfersDTO(Suspicious_phone_transfers suspicious_phone_transfers);
    @Mapping(target = "id", ignore = true)
    Suspicious_phone_transfers toSuspicious_phone_transfers(Suspicious_phone_transfersDTO suspicious_phone_transfersDTO);
}
