package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.Suspicious_account_transfersDTO;
import com.bank.antifraud.entity.Suspicious_account_transfers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Suspicious_account_transfersMapper {
    Suspicious_account_transfersMapper MAPPER = Mappers.getMapper(Suspicious_account_transfersMapper.class);
    Suspicious_account_transfersDTO toSuspicious_account_transfersDTO(Suspicious_account_transfers suspicious_account_transfers);
    @Mapping(target = "id", ignore = true)
    Suspicious_account_transfers toSuspicious_account_transfers(Suspicious_account_transfersDTO suspicious_account_transfersDTO);
}
