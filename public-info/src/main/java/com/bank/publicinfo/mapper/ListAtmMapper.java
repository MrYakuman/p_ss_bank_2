package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.AtmDTO;
import com.bank.publicinfo.entity.Atm;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = AtmMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ListAtmMapper {

    List<Atm> convertToAtm(List<AtmDTO> atmDTOList);

    List<AtmDTO> convertToAtmDTO(List<Atm> atmList);
}
