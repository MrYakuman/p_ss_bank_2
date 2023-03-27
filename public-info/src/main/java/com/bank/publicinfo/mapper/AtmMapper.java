package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.AtmDTO;
import com.bank.publicinfo.dto.BankDetailsDTO;
import com.bank.publicinfo.entity.Atm;
import com.bank.publicinfo.entity.BankDetails;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AtmMapper {

    Atm convertToAtm(AtmDTO atmDTO);

    AtmDTO convertToAtmDTO(Atm atm);

}
