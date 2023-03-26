package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.BankDetailsDTO;
import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.repository.BankDetailsRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BankDetailsMapper {

    BankDetails convertToBankDetails(BankDetailsDTO bankDetailsDTO);

    BankDetailsDTO convertToBankDetailsDTO(BankDetails bankDetails);
}


