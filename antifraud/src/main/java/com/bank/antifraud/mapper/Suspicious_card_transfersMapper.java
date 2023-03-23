package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.Suspicious_card_transfersDTO;
import com.bank.antifraud.entity.Suspicious_card_transfers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Suspicious_card_transfersMapper {
    Suspicious_card_transfersMapper MAPPER = Mappers.getMapper(Suspicious_card_transfersMapper.class);
    Suspicious_card_transfersDTO toSuspicious_card_transfersDTO(Suspicious_card_transfers suspicious_card_transfers);
    @Mapping(target = "id", ignore = true)
    Suspicious_card_transfers toSuspicious_card_transfers(Suspicious_card_transfersDTO suspicious_card_transfersDTO);
}
